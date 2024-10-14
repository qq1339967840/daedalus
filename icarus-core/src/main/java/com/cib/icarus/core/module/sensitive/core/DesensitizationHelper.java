package com.cib.icarus.core.module.sensitive.core;

import com.cib.icarus.core.module.sensitive.SensitiveInfoUtils;
import com.cib.icarus.core.module.sensitive.annotation.BitSensitive;
import com.cib.icarus.core.module.sensitive.annotation.PatternSensitive;
import com.cib.icarus.core.module.sensitive.annotation.StrategySensitive;
import com.cib.icarus.core.module.sensitive.strategy.SensitiveStrategy;
import com.cib.icarus.core.utils.ClassUtils;
import com.cib.icarus.core.utils.StrUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DesensitizationHelper {

    public static boolean notDesensitizationClassType(Object object) {
        return null == object
                || ClassUtils.isPrimitiveType(object.getClass())
                || ClassUtils.isPackageType(object.getClass());
    }

    public static boolean notDesensitizationFieldType(Field field) {
        return  null == field
                || Class.class.isAssignableFrom(field.getType())
                || ClassUtils.isPrimitiveType(field.getType())
                || ClassUtils.isPackageType(field.getType());
    }


    /**
     * @param source 源数据
     * @return 源数据是否可以被处理(脱敏)
     */
    public static boolean canDesensitization(String source) {
        return !StrUtils.isBlank(source) && !"null".equals(source);
    }

    public static String desensitization(final String source, StrategySensitive strategySensitive)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SensitiveStrategy sensitiveStrategy = strategySensitive.strategy().getDeclaredConstructor().newInstance();
        char placeholder = strategySensitive.placeholder();
        return sensitiveStrategy.desensitization(source, placeholder);
    }


    public static String desensitizationByBit(final String source, BitSensitive bitSensitive) {
        char placeholder = bitSensitive.placeholder();
        int begin = bitSensitive.startBit();
        int end = bitSensitive.endBit();
        return desensitizationByBit(source, placeholder, begin, end);
    }

    public static String desensitizationByPattern(String source, PatternSensitive patternSensitive) {
        String placeholder = patternSensitive.placeholder();
        String pattern = patternSensitive.pattern();
        return desensitizationByPattern(source, placeholder, pattern);
    }

    public static String desensitizationByBit(final String source, char placeholder, int begin, int end) {
        if (!canDesensitization(source)) {
            return source;
        }
        return SensitiveInfoUtils.hide(source, placeholder, begin, end);
    }

    public static String desensitizationByPattern(String source, String placeholder, String pattern) {
        if (!canDesensitization(source) || StrUtils.isBlank(pattern)) {
            return source;
        }
        return SensitiveInfoUtils.patternReplace(source, placeholder, pattern);
    }


}
