package com.cib.icarus.core.utils;

import com.cib.icarus.core.module.desensitize.SensitiveInfoUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class SensitiveInfoUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveInfoUtilsTest.class);

    @Test
    public void testSensitiveChsName() {
        assertEquals("*三", SensitiveInfoUtils.hideChsName("张三"));
        assertEquals("李*四", SensitiveInfoUtils.hideChsName("李老四"));
        assertEquals("迪**巴", SensitiveInfoUtils.hideChsName("迪丽热巴"));
        assertEquals("达*****木", SensitiveInfoUtils.hideChsName("达吾提·阿西木"));
    }

    @Test
    public void testSensitiveMobileNo() {
        assertEquals("183****0271", SensitiveInfoUtils.hideMobile("18392480271"));
        assertEquals("1839248027", SensitiveInfoUtils.hideMobile("1839248027"));
    }

    @Test
    public void testSensitiveIdCard() {
        assertEquals("610202********5502", SensitiveInfoUtils.hideIdCard("610202199509175502"));
        assertEquals("35262*****24367", SensitiveInfoUtils.hideIdCard("352627650724367"));
    }

    @Test
    public void testHideFunc() {
        // 阿瓦达索命 length = 13
        String targetStr = "Avada Kedavra";

        assertEquals("A***a Kedavra", SensitiveInfoUtils.hide(targetStr,  '*',1, 4));

        // start & end above boundary
        assertEquals("*************", SensitiveInfoUtils.hide(targetStr,  '*',-1, 15));

        // start above boundary
        assertEquals("************a", SensitiveInfoUtils.hide(targetStr,  '*',-1, 12));

        // end above boundary
        assertEquals("A************", SensitiveInfoUtils.hide(targetStr,  '*',1, 15));

        // start & end in boundary
        assertEquals("*************", SensitiveInfoUtils.hide(targetStr,  '*',0, 13));

        // start in boundary
        assertEquals("**********vra", SensitiveInfoUtils.hide(targetStr,  '*',0, 10));

        // end in boundary
        assertEquals("Avad*********", SensitiveInfoUtils.hide(targetStr, '*', 4, 13));

        // start & end fall on  interval
        assertEquals("Avad******vra", SensitiveInfoUtils.hide(targetStr,  '*',4, 10));
    }

}
