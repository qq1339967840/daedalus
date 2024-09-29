package com.cib.icarus.core.consts;

import com.cib.icarus.core.utils.date.IcarusDateFormatEnum;

/**
 * @author goomba
 */
public interface IcarusGeneralConsts {

    String STR_TO_YES = "1";

    String STR_TO_NO = "0";

    String MAX_YMD_DATE_STR = "9999-12-31";

    IcarusDateFormatEnum MAX_YMD_DATE_FORMAT = IcarusDateFormatEnum.YMD_LONG;

    Long MAX_YMD_DATE_TIMESTAMP = MAX_YMD_DATE_FORMAT.getTimestamp(MAX_YMD_DATE_STR);

}
