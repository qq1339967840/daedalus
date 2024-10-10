package com.cib.icarus.core.utils.id;

import java.security.SecureRandom;
import java.util.UUID;

public class IcarusIdUtils {

    /**
     * @return 获取一个全局唯一的标识符（UUID）并且去掉-
     */
    public static String getSimpleUUID() {
        return getUUID().replaceAll("-", "");
    }

    /**
     * @return 获取一个全局唯一的标识符（UUID）
     */
    public static synchronized String getUUID() {
        return UUID.randomUUID().toString();
    }


    /**
     * 生成一个随机整数，该整数小于指定的上界
     * 使用 SecureRandom 类而不是 Random 类，以提供更强的安全性保证
     * SecureRandom 提供了一个加密安全的随机数生成器，适用于安全敏感的应用程序
     *
     * @param bound 随机数的上界（生成的随机数将小于这个值）
     * @return 生成的随机整数
     */
    public static int getRandomInt(int bound) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(bound);
    }


}
