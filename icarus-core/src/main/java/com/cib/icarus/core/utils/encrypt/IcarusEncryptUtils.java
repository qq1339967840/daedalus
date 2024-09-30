package com.cib.icarus.core.utils.encrypt;

import com.cib.icarus.core.utils.decrypt.IcarusDecryptUtils;
import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class IcarusEncryptUtils {

    public static String encryptBase64(String str) {
        return DatatypeConverter.printBase64Binary(str.getBytes());
    }

//    public static void main(String[] args) {
//        System.out.println(encodeHmacSHA1("zhengyi", "dassdasdx"));
//        System.out.println(IcarusDecryptUtils.decodeHmacSHA1("a1EpJY5iS4+ezK71Ac4LoOO4KIE=", "dassdasdx"));
//    }

//    public static String encodeHmacSHA1(String stringToSign, String accessKeySecret) {
//        final String ALGORITHM_NAME = "HmacSHA1";
//        try {
//            Mac mac = Mac.getInstance(ALGORITHM_NAME);
//            mac.init(new SecretKeySpec(
//                    accessKeySecret.getBytes(StandardCharsets.UTF_8),
//                    ALGORITHM_NAME
//            ));
//            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
//            return BaseEncoding.base64().encode(signData);
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            throw new IllegalArgumentException(e.toString());
//        }
//    }
}
