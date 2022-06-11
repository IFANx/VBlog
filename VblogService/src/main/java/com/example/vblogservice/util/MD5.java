package com.example.vblogservice.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {
    /**
     *
     * @param plainText 初始密码
     * @return 加密密码
     */
    public String getCiphertext(String plainText) {
        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No MD5 Algorithm");
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));// 16进制数字
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code.insert(0, "0");
        }
        String code = md5code.toString();
        code = code.substring(16) + code.substring(0,16);
        return code;
    }
    /**
     *
     * @param plainText 验证密码
     * @param cipherText 数据库密码
     * @return 是否相等
     */
    public boolean verify(String plainText, String cipherText) {
        return getCiphertext(plainText).equals(cipherText);
    }
}