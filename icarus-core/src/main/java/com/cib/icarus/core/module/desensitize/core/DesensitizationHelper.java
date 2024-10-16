package com.cib.icarus.core.module.desensitize.core;

import com.cib.icarus.core.module.desensitize.DesensitizeInfoUtils;
import com.cib.icarus.core.module.desensitize.annotation.BitDesensitize;
import com.cib.icarus.core.module.desensitize.annotation.PatternDesensitize;
import com.cib.icarus.core.module.desensitize.annotation.StrategyDesensitize;
import com.cib.icarus.core.module.desensitize.strategy.DesensitizeStrategy;
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

    public static String desensitization(final String source, StrategyDesensitize strategyDesensitize)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DesensitizeStrategy desensitizeStrategy = strategyDesensitize.strategy().getDeclaredConstructor().newInstance();
        char placeholder = strategyDesensitize.placeholder();
        return desensitizeStrategy.desensitization(source, placeholder);
    }


    public static String desensitizationByBit(final String source, BitDesensitize bitDesensitize) {
        char placeholder = bitDesensitize.placeholder();
        int begin = bitDesensitize.startBit();
        int end = bitDesensitize.endBit();
        return desensitizationByBit(source, placeholder, begin, end);
    }

    public static String desensitizationByPattern(String source, PatternDesensitize patternDesensitize) {
        String placeholder = patternDesensitize.placeholder();
        String pattern = patternDesensitize.pattern();
        return desensitizationByPattern(source, placeholder, pattern);
    }

    public static String desensitizationByBit(final String source, char placeholder, int begin, int end) {
        if (!canDesensitization(source)) {
            return source;
        }
        return DesensitizeInfoUtils.hide(source, placeholder, begin, end);
    }

    public static String desensitizationByPattern(String source, String placeholder, String pattern) {
        if (!canDesensitization(source) || StrUtils.isBlank(pattern)) {
            return source;
        }
        return DesensitizeInfoUtils.patternReplace(source, placeholder, pattern);
    }


}
