package com.cib.icarus.common.helper.date;

public enum IcarusDateFormatEnum {

    YMD_SHORT("yyyyMMdd"),
    YMD_LONG("yyyy-MM-dd"),

    YMD_HMS_SHORT("yyyyMMdd HH:mm:ss"),

    YMD_HMS_LONG("yyyy-MM-dd HH:mm:ss");


    private final String dateFormat;

    IcarusDateFormatEnum(String dateFormat) {
        this.dateFormat = dateFormat;
    }


    public String getDateFormat() {
        return dateFormat;
    }
}
