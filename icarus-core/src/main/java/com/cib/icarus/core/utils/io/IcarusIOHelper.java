package com.cib.icarus.core.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public static void close(InputStreamReader isr) {
        if (isr != null) {
            try {
                isr.close();
            } catch (IOException ignore) {
            }
        }
    }

}
