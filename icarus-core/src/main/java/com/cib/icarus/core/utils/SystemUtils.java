package com.cib.icarus.core.utils;

public class SystemUtils {

    public static boolean isWindows() {
        String osName = System.getProperty("os.name");
        if (StrUtils.isBlank(osName)) {
            return false;
        }
        return osName.startsWith("Windows");
    }

}
