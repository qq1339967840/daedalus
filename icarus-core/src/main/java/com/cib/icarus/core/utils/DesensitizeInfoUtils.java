package com.cib.icarus.core.utils;


import com.cib.icarus.core.consts.IcarusGeneralConsts;
import com.cib.icarus.core.enums.IcarusRegexEnum;

/**
 * 协助完成敏感信息处理
 */
public class DesensitizeInfoUtils {
    
    public static String hideEmail(String target) {
        return hideEmail(target, IcarusGeneralConsts.DEFAULT_PLACEHOLDER_STR);
    }

    public static String hideEmail(String target, String placeholder) {
        if (IcarusRegexEnum.EMAIL.notMatch(target)) {
            return target;
        }
        String patternStr = "^(^\\w{1,2})(\\w+)@(.*)(\\..*$)";
        String replaceStr = "$1" + placeholder + placeholder + placeholder + placeholder + "$3$4";
        return patternReplace(target, replaceStr, patternStr);
    }

    public static String hideMobile(String mobileNo) {
        return hideMobile(mobileNo, IcarusGeneralConsts.DEFAULT_PLACEHOLDER_CHAR);
    }

    public static String hideMobile(String mobileNo, char placeholder) {
        if (IcarusRegexEnum.MOBILE.notMatch(mobileNo)) {
            return mobileNo;
        }

        return hide(mobileNo, placeholder, 3, 7);
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
        return hideIdCard(idCard, IcarusGeneralConsts.DEFAULT_PLACEHOLDER_CHAR);
    }

    public static String hideIdCard(String idCard, char placeholder) {
        if (IcarusRegexEnum.ID_CARD.notMatch(idCard)) {
            return idCard;
        }

        if (idCard.length() == 15) {
            return hide(idCard, placeholder, 5, 10);
        }

        if (idCard.length() == 18) {
            return hide(idCard, placeholder, 6, 14);
        }
        return idCard;
    }

    public static String hideChsName(String chsName, char placeholder) {
        if (IcarusRegexEnum.CHS_NAME.notMatch(chsName)) {
            return chsName;
        }
        if (chsName.length() == 2) {
            return hide(chsName, placeholder, 0, 1);
        }
        return hide(chsName, placeholder, 1, chsName.length() - 1);
    }

    /**
     * 对于超过两个字的姓名，保留首尾两个字，中间用*代替。例如，‌张无忌脱敏后变为张*忌。
     * 对于两个字的名字，保留最后一个字，第一个字用*代替。例如，‌嬴政脱敏后变为*政。
     */
    public static String hideChsName(String chsName) {
        return hideChsName(chsName, IcarusGeneralConsts.DEFAULT_PLACEHOLDER_CHAR);
    }


    public static String hide(final String source, char placeholder, int start, int end) {
        if (null == source || source.isEmpty()) {
            return source;
        }
        start = Math.max(start, 0);
        end = Math.min(end, source.length());

        StringBuilder sb = new StringBuilder(source);

        for (int i = start; i < end; i++) {
            sb.setCharAt(i, placeholder);
        }
        return sb.toString();
    }

    public static String patternReplace(String content, String replace, String pattern) {
        return content.replaceAll(pattern, replace);
    }


}
