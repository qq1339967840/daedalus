package com.cib.icarus.core.utils.decrypt;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class IcarusDecryptUtils {

    public static String decryptBase64(String encryptStr) {
        byte[] bytes = DatatypeConverter.parseBase64Binary(encryptStr);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
