package com.cib.icarus.common.test.helper.regex;

import com.cib.icarus.common.utils.regex.IcarusRegexUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IcarusRegexHelperTest {

    private static final Logger logger = LoggerFactory.getLogger(IcarusRegexUtils.class);

    @Test
    public void isMobileNo() {
        String mobile1 = "18392480273";
        String mobile2 = "1839248027a";
        logger.info("返回结果1：{}", IcarusRegexUtils.isMobileNo(mobile1));
        logger.info("返回结果2：{}", IcarusRegexUtils.isMobileNo(mobile2));
    }


}
