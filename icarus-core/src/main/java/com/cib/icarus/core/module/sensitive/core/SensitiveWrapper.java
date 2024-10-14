package com.cib.icarus.core.module.sensitive.core;

import com.cib.icarus.core.module.sensitive.annotation.BitSensitive;
import com.cib.icarus.core.module.sensitive.annotation.PatternSensitive;
import com.cib.icarus.core.module.sensitive.annotation.StrategySensitive;
import org.reflections.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public interface SensitiveWrapper {

    Logger logger = LoggerFactory.getLogger(SensitiveWrapper.class);

    default Object sensitive(Object object) {
        try {
            // TODO 该类需要进行深拷贝
            // Object newObject = object.getClass().newInstance();
            // BeanUtils.copyProperties(object, newObject);
            return doSensitive(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }


    default Object doSensitive(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        // if null or primitive type or package type, return directly
        if (DesensitizationHelper.notDesensitizationClassType(object)) {
            return object;
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
            StrategySensitive strategySensitive = getAnnotation(field, StrategySensitive.class);
            if (strategySensitive != null) {
                sensitive = DesensitizationHelper.desensitization(source, strategySensitive);
            }

            BitSensitive bitSensitive = getAnnotation(field, BitSensitive.class);
            if (bitSensitive != null) {
                sensitive = DesensitizationHelper.desensitizationByBit(source, bitSensitive);
            }

            PatternSensitive patternSensitive = getAnnotation(field, PatternSensitive.class);
            if (patternSensitive != null) {
                sensitive = DesensitizationHelper.desensitizationByPattern(source, patternSensitive);
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
                newArray[i] = doSensitive(array[i]);
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
                resultList.add(doSensitive(item));
            }
            field.set(object, resultList);
            return;
        }

        Object res = doSensitive(field.get(object));
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
