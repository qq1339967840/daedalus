package com.cib.icarus.common.utils;

import com.cib.icarus.common.utils.regex.IcarusRegexUtils;

/**
 * 协助完成敏感信息处理
 */
public class SensitiveInfoUtils {


    public static void main(String[] args) {
        System.out.println(hideMobile("18392480273"));
        System.out.println(hideChsName("郑义"));
        System.out.println(hideChsName("涨价函"));
        System.out.println(hideChsName("司马相如"));
    }

    public static String hideMobile(String mobileNo) {
        if (!IcarusRegexUtils.isMobileNo(mobileNo)) {
            return mobileNo;
        }
        return hide(mobileNo, 3, 7);
    }

    /**
     * 对于超过两个字的姓名，保留首尾两个字，中间用*代替。例如，‌张无忌脱敏后变为张*忌。
     * 对于两个字的名字，保留最后一个字，第一个字用*代替。例如，‌嬴政脱敏后变为*政。
     */
    public static String hideChsName(String chsName) {
        if (!IcarusRegexUtils.isChsName(chsName)) {
            return chsName;
        }
        if (chsName.length() == 2) {
            return hide(chsName, 0, 1);
        }
        return hide(chsName, 1, chsName.length() - 1);
    }


    public static String hide(String targetStr, int start, int end) {
        if (null == targetStr || targetStr.isEmpty()) {
            return targetStr;
        }
        start = Math.min(start, targetStr.length() - 1);
        end = Math.min(end, targetStr.length() - 1);


        StringBuilder sb = new StringBuilder(targetStr);

        for (int i = start; i < end; i++) {
            sb.setCharAt(i, '*');
        }
        return sb.toString();
    }


}
