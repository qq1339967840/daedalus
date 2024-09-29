package com.cib.icarus.core.utils.date;

import com.cib.icarus.core.consts.IcarusGeneralConsts;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;

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
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.of("+8"))
                .format(DateTimeFormatter.ofPattern(dateFormat));
    }

    public Long getTimestamp(String dateStr) {
        if (isLocalDateDealFormat(dateFormat)) {
            LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(dateFormat));
            return localDate.atStartOfDay().atZone(ZoneOffset.of("+8")).toInstant().toEpochMilli();
        }

        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(dateFormat));
        return localDateTime.atZone(ZoneOffset.of("+8")).toInstant().toEpochMilli();
    }

    private boolean isLocalDateDealFormat(String dateFormat) {
        return dateFormat.equals(YMD_SHORT.getDateFormat()) || dateFormat.equals(YMD_LONG.getDateFormat())
                || dateFormat.equals(YMD_CHS.getDateFormat());
    }


}
