package com.cib.icarus.core.utils.encrypt;

import com.cib.icarus.core.utils.ByteUtils;
import com.cib.icarus.core.utils.decrypt.IcarusDecryptUtils;
import com.google.common.io.BaseEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IcarusEncryptUtils {

    private static final Logger logger = LoggerFactory.getLogger(IcarusEncryptUtils.class);

    public static String base64(String str) {
        return DatatypeConverter.printBase64Binary(str.getBytes());
    }

    /**
     * 对给定字符串使用指定的哈希算法进行哈希处理
     *
     * @param target    待哈希处理的字符串
     * @param algorithm 指定的哈希算法名称，例如"MD5"或"SHA-256"
     * @return 返回哈希处理后的字符串，以十六进制形式表示
     */
    public static String hash(String target, String algorithm) {
        try {
            MessageDigest md5 = MessageDigest.getInstance(algorithm);
            byte[] messageDigest = md5.digest(target.getBytes());
            return ByteUtils.arrayToHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用MD5算法对字符串进行哈希
     *
     * @param target 待哈希的字符串
     * @return 哈希后的MD5字符串
     */
    public static String md5(String target) {
        return hash(target, "md5");
    }

    /**
     * 使用 SHA-256 算法对字符串进行哈希
     *
     * @param target 待哈希的字符串
     * @return 哈希后的SHA-256字符串
     */
    public static String sha256(String target) {
        return hash(target, "sha-256");
    }

    /**
     * 使用HMAC-SHA1算法对字符串进行签名
     *
     * @param stringToSign    待签名的字符串
     * @param accessKeySecret 用于签名的密钥
     * @return 返回签名后的Base64编码字符串
     * @throws IllegalArgumentException 如果算法不支持或密钥无效，则抛出此异常
     */
    public static String hmacSha1(String stringToSign, String accessKeySecret) {
        try {
            // 创建HMAC-SHA1算法实例
            Mac mac = Mac.getInstance("HmacSHA1");
            // 初始化密钥
            mac.init(new SecretKeySpec(accessKeySecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
            // 执行签名并获得签名数据
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            // 返回签名后的Base64编码字符串
            return BaseEncoding.base64().encode(signData);
        } catch (NoSuchAlgorithmException e) {
            // 记录日志
            logger.error("Error in HMAC-SHA1 signing: " + e.getMessage());
            // 如果算法不支持，则抛出异常
            throw new IllegalArgumentException("Algorithm not found", e);
        } catch (InvalidKeyException e) {
            // 记录日志
            logger.error("Error in HMAC-SHA1 signing: " + e.getMessage());
            // 如果密钥无效，则抛出异常
            throw new IllegalArgumentException("Invalid key", e);
        }
    }


}
