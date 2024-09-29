package com.cib.icarus.core.utils.date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class IcarusDateFormatEnumUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(IcarusDateFormatEnumUtilsTest.class);

    @Test
    public void printCurrentDate() {
        // current date change every time, so that just print it
        // ymd
        logger.info(IcarusDateFormatEnum.YMD_SHORT.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_LONG.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_CHS.getCurrentDateStr());
        // ymd hms
        logger.info(IcarusDateFormatEnum.YMD_HMS_SHORT.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_HMS_MEDIUM.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_HMS_LONG.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_HMS_CHS.getCurrentDateStr());
        // ymd hms SSS
        logger.info(IcarusDateFormatEnum.YMD_HMS_MIS_SHORT.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_HMS_MIS_MEDIUM.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_HMS_MIS_LONG.getCurrentDateStr());
        logger.info(IcarusDateFormatEnum.YMD_HMS_MIS_CHS.getCurrentDateStr());
    }

    @Test
    public void testDataStr() {
        long timestamp = 1727575191266L;
        assertEquals("20240929", IcarusDateFormatEnum.YMD_SHORT.getDateStr(timestamp));
        assertEquals("2024-09-29", IcarusDateFormatEnum.YMD_LONG.getDateStr(timestamp));
        assertEquals("2024年09月29日", IcarusDateFormatEnum.YMD_CHS.getDateStr(timestamp));
        
        assertEquals("20240929095951", IcarusDateFormatEnum.YMD_HMS_SHORT.getDateStr(timestamp));
        assertEquals("20240929 09:59:51", IcarusDateFormatEnum.YMD_HMS_MEDIUM.getDateStr(timestamp));
        assertEquals("2024-09-29 09:59:51", IcarusDateFormatEnum.YMD_HMS_LONG.getDateStr(timestamp));
        assertEquals("2024年09月29日 09时59分51秒", IcarusDateFormatEnum.YMD_HMS_CHS.getDateStr(timestamp));

        assertEquals("20240929095951266", IcarusDateFormatEnum.YMD_HMS_MIS_SHORT.getDateStr(timestamp));
        assertEquals("20240929 09:59:51.266", IcarusDateFormatEnum.YMD_HMS_MIS_MEDIUM.getDateStr(timestamp));
        assertEquals("2024-09-29 09:59:51.266", IcarusDateFormatEnum.YMD_HMS_MIS_LONG.getDateStr(timestamp));
        assertEquals("2024年09月29日 09时59分51秒266毫秒", IcarusDateFormatEnum.YMD_HMS_MIS_CHS.getDateStr(timestamp));
    }


}
