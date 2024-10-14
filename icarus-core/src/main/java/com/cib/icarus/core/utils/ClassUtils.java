package com.cib.icarus.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public static Object newInstance(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(object);
            return mapper.readValue(json, object.getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
