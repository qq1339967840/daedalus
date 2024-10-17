package com.cib.icarus.core.utils;

public class StrUtils {

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
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


    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
