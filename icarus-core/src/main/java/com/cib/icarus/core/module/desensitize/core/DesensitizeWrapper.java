package com.cib.icarus.core.module.desensitize.core;

import com.cib.icarus.core.module.desensitize.annotation.BitDesensitize;
import com.cib.icarus.core.module.desensitize.annotation.PatternDesensitize;
import com.cib.icarus.core.module.desensitize.annotation.StrategyDesensitize;
import com.cib.icarus.core.utils.ClassUtils;
import org.reflections.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public interface DesensitizeWrapper {

    Logger logger = LoggerFactory.getLogger(DesensitizeWrapper.class);

    default Object desensitize(Object object) {
        try {
            // 处理迭代器模式相关的
            if (Iterable.class.isAssignableFrom(object.getClass())) {
                Iterable<?> iterable = (Iterable<?>) object;
                List<Object> resultList = new ArrayList<>();
                for (Object item : iterable) {
                    resultList.add(desensitize(item));
                }
                return resultList;
            }

            Object newObject = ClassUtils.newInstance(object);
            return doDesensitize(newObject);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }


    default Object doDesensitize(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        // if null or primitive type or package type, return directly
        if (DesensitizationHelper.notDesensitizationClassType(object)) {
            return object;
        }

        if (object.getClass().isArray()) {
            Object[] array = (Object[]) object;
            Object[] newArray = Arrays.copyOf(array, array.length);
            for (int i = 0; i < array.length; i++) {
                newArray[i] = doDesensitize(array[i]);
            }
            return newArray;
        }

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {

            // 如果是基础类型或包装类型，跳过不处理
            if (DesensitizationHelper.notDesensitizationFieldType(field)) {
                continue;
            }

            // 不是字符串类型，进行额外处理。
            if (!Objects.equals(field.getType(), String.class)) {
                dealForNotString(field, object);
                continue;
            }

            // 是字符串类型，进行脱敏
            field.setAccessible(true);
            String source = String.valueOf(field.get(object));
            String sensitive = source;

            // 依次加载策略注解 StrategySensitive -> BitSensitive -> PatternSensitive。如果同時存在后面的会覆盖前面的值
            StrategyDesensitize strategyDesensitize = getAnnotation(field, StrategyDesensitize.class);
            if (strategyDesensitize != null) {
                sensitive = DesensitizationHelper.desensitization(source, strategyDesensitize);
            }

            BitDesensitize bitDesensitize = getAnnotation(field, BitDesensitize.class);
            if (bitDesensitize != null) {
                sensitive = DesensitizationHelper.desensitizationByBit(source, bitDesensitize);
            }

            PatternDesensitize patternDesensitize = getAnnotation(field, PatternDesensitize.class);
            if (patternDesensitize != null) {
                sensitive = DesensitizationHelper.desensitizationByPattern(source, patternDesensitize);
            }

            field.set(object, sensitive);
        }
        return object;
    }


    default void dealForNotString(Field field, Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        // 其他情况递归
        field.setAccessible(true);

        // 如果是数组类型的对象,遍历数组类型的元素进行递归
        if (field.getType().isArray()) {
            Object[] array = (Object[]) field.get(object);
            if (array == null) {
                return;
            }
            Object[] newArray = Arrays.copyOf(array, array.length);
            for (int i = 0; i < array.length; i++) {
                newArray[i] = doDesensitize(array[i]);
            }
            field.set(object, newArray);
            return;
        }

        // 如果该元素可以被迭代
        if (Iterable.class.isAssignableFrom(field.getType())) {
            Iterable<?> iterable = (Iterable<?>) field.get(object);
            if (iterable == null) {
                return;
            }
            List<Object> resultList = new ArrayList<>();
            for (Object item : iterable) {
                resultList.add(doDesensitize(item));
            }
            field.set(object, resultList);
            return;
        }

        Object res = doDesensitize(field.get(object));
        field.set(object, res);
    }


    default <T> T getAnnotation(Field field, Class<T> annotationClass) {
        // FIXME need to replace this function with ReflectionUtils
        Set<Annotation> annotations = ReflectionUtils.getAllAnnotations(field);
        for (Annotation annotation : annotations) {
            if (Objects.equals(annotation.annotationType(), annotationClass)) {
                return (T) annotation;
            }
        }
        return null;
    }

}
