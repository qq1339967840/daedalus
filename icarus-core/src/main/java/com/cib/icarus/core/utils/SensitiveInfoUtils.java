package com.cib.icarus.core.utils;


import com.cib.icarus.core.utils.regex.IcarusRegexEnum;

/**
 * 协助完成敏感信息处理
 */
public class SensitiveInfoUtils {

    public static String hideMobile(String mobileNo) {
        if (IcarusRegexEnum.MOBILE.notMatch(mobileNo)) {
            return mobileNo;
        }

        return hide(mobileNo, 3, 7);
    }

    /**
     * 身份证脱敏方法
     * 根据身份证的长度，对身份证号码进行不同位置的脱敏处理
     * 脱敏规则：15位身份证脱敏从第6位到第10位，18位身份证脱敏从第7位到第14位
     * 其他长度的身份证号码则原样返回
     *
     * @param idCard 身份证号码字符串
     * @return 脱敏后的身份证号码字符串
     */
    public static String hideIdCard(String idCard) {
        if (IcarusRegexEnum.ID_CARD.notMatch(idCard)) {
            return idCard;
        }

        if (idCard.length() == 15) {
            return hide(idCard, 5, 10);
        }

        if (idCard.length() == 18) {
            return hide(idCard, 6, 14);
        }
        return idCard;
    }


    /**
     * 对于超过两个字的姓名，保留首尾两个字，中间用*代替。例如，‌张无忌脱敏后变为张*忌。
     * 对于两个字的名字，保留最后一个字，第一个字用*代替。例如，‌嬴政脱敏后变为*政。
     */
    public static String hideChsName(String chsName) {
        if (IcarusRegexEnum.CHS_NAME.notMatch(chsName)) {
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
        start = Math.max(start, 0);
        end = Math.min(end, targetStr.length());

        StringBuilder sb = new StringBuilder(targetStr);

        for (int i = start; i < end; i++) {
            sb.setCharAt(i, '*');
        }
        return sb.toString();
    }


}
