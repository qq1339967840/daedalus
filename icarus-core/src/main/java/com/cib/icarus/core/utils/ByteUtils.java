package com.cib.icarus.core.utils;

import com.cib.icarus.core.consts.IcarusGeneralConsts;

public class ByteUtils {


    /**
     * 将字节数组转换为十六进制字符串
     * 此方法用于将给定的字节数组转换成其十六进制表示的字符串形式
     * 在加密算法或数据校验等场景中，经常需要将数据转换为十六进制格式以方便处理或传输
     *
     * @param bytes 待转换的字节数组，不能为空
     * @return 表示字节数组的十六进制字符串
     * @throws IllegalArgumentException 如果输入的字节数组为null，则抛出此异常
     */
    public static String arrayToHexString(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("Input byte array must not be null!");
        }

        // 预定义的字符数组，用于快速转换字节为十六进制字符串
        char[] hexArray = "0123456789abcdef".toCharArray();

        // 创建StringBuilder用于拼接十六进制字符串，初始容量为字节数组长度的两倍
        StringBuilder hexString = new StringBuilder(bytes.length * 2);

        // 遍历字节数组，将每个字节转换为十六进制字符串
        for (byte b : bytes) {
            // 将字节转换为无符号的十六进制值
            int v = b & 0xFF;
            // 将高四位和低四位分别转换为十六进制字符并拼接到结果中
            hexString.append(hexArray[v >>> 4]);
            hexString.append(hexArray[v & 0x0F]);
        }

        return hexString.toString();
    }


    /**
     * 将十六进制字符串转换为字节数组
     * 此方法用于解析以十六进制形式表示的字符串，将其还原为原始的字节数组
     * 该方法首先校验输入字符串是否为空，并确保字符串长度为偶数，因为每个字节由两个十六进制字符表示
     *
     * @param hexString 十六进制字符串，不能为空且长度必须为偶数
     * @return 对应的字节数组
     * @throws IllegalArgumentException 如果输入字符串为空或长度不为偶数，则抛出此异常
     */
    public static byte[] hexStringToArray(String hexString) {
        if (StrUtils.isBlank(hexString)) {
            throw new IllegalArgumentException("input hexString must be not null");
        }
        hexString = hexString.replaceAll(IcarusGeneralConsts.BLANK_STR, IcarusGeneralConsts.EMPTY_STR);
        if (hexString.length() % 2 != 0) {
            throw new IllegalArgumentException("Input hexString length must be even");
        }

        // 验证输入字符串是否只包含合法的十六进制字符
        if (!hexString.matches("[0-9A-Fa-f]+")) {
            throw new IllegalArgumentException("Input hexString contains invalid characters");
        }

        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            // 将两个字符转换为一个字节，即一个十六进制字符对应一个字节
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i + 1), 16));
        }
        return bytes;
    }

}
