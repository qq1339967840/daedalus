package com.cib.icarus.core;

public class Icarus {
    public final static String VERSION = "Icarus-" + Icarus.class.getPackage().getImplementationVersion();

    public static String getVersion() {
        return VERSION;
    }
}
