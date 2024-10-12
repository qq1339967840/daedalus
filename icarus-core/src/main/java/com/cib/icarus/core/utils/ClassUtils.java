package com.cib.icarus.core.utils;

public class ClassUtils {

    public static boolean isPackageType(Class<?> clazz) {
        return clazz == Boolean.class || clazz == Byte.class
                || clazz == Character.class || clazz == Double.class
                || clazz == Float.class || clazz == Integer.class
                || clazz == Long.class || clazz == Short.class;
    }


    public static boolean isPrimitiveType(Class<?> clazz) {
        return clazz.isPrimitive();
    }

}
