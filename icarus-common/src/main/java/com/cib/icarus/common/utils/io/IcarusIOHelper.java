package com.cib.icarus.common.utils.io;

import java.io.IOException;
import java.io.InputStream;

public class IcarusIOHelper {

    public static final int EOF = -1;

    public static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException ignore) {
            }
        }
    }

}
