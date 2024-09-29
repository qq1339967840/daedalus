package com.cib.icarus.core.utils.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author goomba
 */
public enum IcarusDateFormatEnum {

    YMD_SHORT("yyyyMMdd"),
    YMD_LONG("yyyy-MM-dd"),
    YMD_CHS("yyyy年MM月dd日"),

    YMD_HMS_SHORT("yyyyMMddHHmmss"),
    YMD_HMS_MEDIUM("yyyyMMdd HH:mm:ss"),
    YMD_HMS_LONG("yyyy-MM-dd HH:mm:ss"),
    YMD_HMS_CHS("yyyy年MM月dd日 HH时mm分ss秒"),


    YMD_HMS_MIS_SHORT("yyyyMMddHHmmssSSS"),
    YMD_HMS_MIS_MEDIUM("yyyyMMdd HH:mm:ss.SSS"),
    YMD_HMS_MIS_LONG("yyyy-MM-dd HH:mm:ss.SSS"),
    YMD_HMS_MIS_CHS("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒"),
    ;
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
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(dateFormat));
    }


}
