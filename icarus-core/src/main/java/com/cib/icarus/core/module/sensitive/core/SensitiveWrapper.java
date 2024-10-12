package com.cib.icarus.core.module.sensitive.core;

import com.cib.icarus.core.module.sensitive.annotation.BitSensitive;
import com.cib.icarus.core.module.sensitive.annotation.PatternSensitive;
import com.cib.icarus.core.module.sensitive.annotation.StrategySensitive;
import com.cib.icarus.core.utils.ClassUtils;
import org.reflections.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Set;

public interface SensitiveWrapper {

    default Object sensitive(Object object) {
        try {
            return doSensitive(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }


    default Object doSensitive(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (ClassUtils.isPrimitiveType(field.getType()) || ClassUtils.isPackageType(field.getType())) {
                // 如果是基础类型或包装类型，跳过不处理
                continue;
            }

            // 不是字符串类型，继续递归
            if (!Objects.equals(field.getType(), String.class)) {
                doSensitive(field);
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
