package com.cib.icarus.common.helper.regex;

public class IcarusRegexHelper {

    public static boolean isMobileNo(String targetStr) {
        return match(targetStr, IcarusRegexEnum.MOBILE);
    }

    public static boolean isIdCard(String targetStr) {
        return match(targetStr, IcarusRegexEnum.ID_CARD);
    }

    public static boolean isChsName(String targetStr) {
        return match(targetStr, IcarusRegexEnum.CHS_NAME);
    }

    public static boolean isEmail(String targetStr) {
        return match(targetStr, IcarusRegexEnum.EMAIL);
    }

    public static boolean isNumber(String targetStr) {
        return match(targetStr, IcarusRegexEnum.NUMBER);
    }

    public static boolean isIpv4(String targetStr) {
        return match(targetStr, IcarusRegexEnum.IPV4);
    }

    public static boolean match(String targetStr, IcarusRegexEnum regexEnum) {
        // TODO
        return false;
    }

    public static boolean match(String targetStr, String regex) {
        // TODO
        return false;
    }

}
