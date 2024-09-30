package com.cib.icarus.core.utils.id;

import java.security.SecureRandom;
import java.util.UUID;

public class IcarusIdUtils {

    public static String getSimpleUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static int getRandomInt(int bound) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(bound);
    }

}
