package com.cib.icarus.core.utils.regex;


import java.util.regex.Pattern;

/**
 * icarus正则表达式枚举
 *
 * @author zhengyi
 */
public enum IcarusRegexEnum {
    MOBILE("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$"),
    EMAIL("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"),
    ID_CARD("^\\d{15}|\\d{18}$"),
    CHS_NAME("^[\\u4e00-\\u9fa5·]{0,}$"),
    NUMBER("^(\\-|\\+)?\\d+(\\.\\d+)?$"),
    IPV4("^(\\-|\\+)?\\d+(\\.\\d+)?$");

    private final String regex;

    private final Pattern pattern;

    IcarusRegexEnum(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public String getRegex() {
        return regex;
    }

    public boolean match(String target) {
        return pattern.matcher(target).find();
    }

    public boolean notMatch(String target) {
        return !match(target);
    }

}
