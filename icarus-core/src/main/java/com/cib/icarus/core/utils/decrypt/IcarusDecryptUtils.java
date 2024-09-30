package com.cib.icarus.core.utils.decrypt;

import com.google.common.io.BaseEncoding;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class IcarusDecryptUtils {

    public static String decryptBase64(String encryptStr) {
        byte[] bytes = DatatypeConverter.parseBase64Binary(encryptStr);
        return new String(bytes, StandardCharsets.UTF_8);
    }

//    public static String decodeHmacSHA1(String target, String accessKeySecret) {
//        final String ALGORITHM_NAME = "HmacSHA1";
//        try {
//            SecretKey secretKey = KeyGenerator.getInstance(accessKeySecret).generateKey();
//            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), ALGORITHM_NAME);
//
//            Mac mac = Mac.getInstance(ALGORITHM_NAME);
//            mac.init(secretKeySpec);
//            byte[] signData = mac.doFinal(target.getBytes(StandardCharsets.UTF_8));
//            return new String(signData, StandardCharsets.UTF_8);
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            throw new IllegalArgumentException(e.toString());
//        }
//    }
}
