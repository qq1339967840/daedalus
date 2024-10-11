package com.cib.icarus.core.utils;

/**
 * 谓语断言
 */
public class Predicate {

    public static void asserts(boolean condition, String errorMsg) {
        if (!condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static void include(String target, String errorMsg, String... values) {
        for (String value : values) {
            if (target.contains(value)) {
                return;
            }
        }
        throw new IllegalArgumentException(errorMsg);
    }

}
