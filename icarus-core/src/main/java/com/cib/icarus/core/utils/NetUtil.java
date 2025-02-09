package com.cib.icarus.core.utils;

import com.cib.icarus.core.utils.io.IcarusIOHelper;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class NetUtil {

    private static final int DEFAULT_TIMEOUT_IN_SECONDS = 60;

    /**
     * 该函数用于检测URL是否可访问。主要功能包括：
     * 使用给定地址创建URL对象。
     * 打开连接并设置请求方法为GET。
     * 禁用缓存和设置超时时间。
     * 获取响应状态码，并在状态码为200到399之间时返回true，表示请求成功。若过程中出现异常，则返回false。
     */
    public static boolean pingUrl(String address) {
        try {
            URL urlObj = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(DEFAULT_TIMEOUT_IN_SECONDS);
            connection.setReadTimeout(DEFAULT_TIMEOUT_IN_SECONDS);
            int statusCode = connection.getResponseCode();
            cleanUpConnection(connection);
            return (200 <= statusCode && statusCode <= 399);
        } catch (Throwable ignore) {
        }
        return false;
    }

    /**
     * according to <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/net/http-keepalive.html">
     * we should clean up the connection by reading the response body so that the connection could be reused.</a>,
     */
    private static void cleanUpConnection(HttpURLConnection conn) {
        InputStreamReader isr = null;
        InputStreamReader esr = null;
        try {
            isr = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            String ignoreIStr = CharStreams.toString(isr);
        } catch (IOException e) {
            InputStream errorStream = conn.getErrorStream();

            if (errorStream != null) {
                esr = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                try {
                    String ignoreEStr = CharStreams.toString(esr);
                } catch (IOException ignore) {
                }
            }
        } finally {
            IcarusIOHelper.close(isr);
            IcarusIOHelper.close(esr);
        }
    }
}
