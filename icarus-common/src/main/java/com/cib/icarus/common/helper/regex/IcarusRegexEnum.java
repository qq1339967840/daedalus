package com.cib.icarus.common.helper.regex;


/**
 * icarus正则表达式枚举
 * TODO
 *
 * @author zhengyi
 */
public enum IcarusRegexEnum {
    MOBILE(""), EMAIL(""), ID_CARD(""), CHS_NAME(""), NUMBER(""), IPV4("");

    private final String regex;

    IcarusRegexEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
