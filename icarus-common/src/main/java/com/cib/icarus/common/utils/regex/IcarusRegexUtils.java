package com.cib.icarus.common.utils.regex;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class IcarusRegexUtils {

    private static final Map<String, Pattern> STRING_MATCHER_MAP = new ConcurrentHashMap<>();

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
        return getPattern(regexEnum.getRegex()).matcher(targetStr).find();
    }

    public static boolean match(String targetStr, String regex) {
        return getPattern(regex).matcher(targetStr).find();
    }

    private static Pattern getPattern(String regex) {
        if (STRING_MATCHER_MAP.containsKey(regex)) {
            return STRING_MATCHER_MAP.get(regex);
        }
        STRING_MATCHER_MAP.putIfAbsent(regex, Pattern.compile(regex));
        return STRING_MATCHER_MAP.get(regex);
    }

}
