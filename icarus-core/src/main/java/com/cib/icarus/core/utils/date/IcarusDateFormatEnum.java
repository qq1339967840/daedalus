package com.cib.icarus.core.utils.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public String getCurrentDateStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat));
    }

    public String getDateStr(Long timestamp) {
        if (null == timestamp) {
            throw new IllegalArgumentException("timestamp must not be null!");
        }
        // TODO
        return null;
        //LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat));
    }


}
