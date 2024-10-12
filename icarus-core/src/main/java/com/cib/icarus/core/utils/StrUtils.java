package com.cib.icarus.core.utils;

public class StrUtils {

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }


    public static boolean equals(String str1, String str2) {
        if (isBlank(str1) && isBlank(str2)) {
            return true;
        }
        if (isBlank(str1) || isBlank(str2)) {
            return false;
        }
        return str1.equals(str2);
    }

}
