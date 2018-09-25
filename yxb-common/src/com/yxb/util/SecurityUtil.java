package com.yxb.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by bing on 2018/09/19.
 */
public class SecurityUtil {

    private static final String CHARACTER_TYPE = "UTF-8";

    /**
     * 对称加密
     *
     * @param key 指定密钥
     * @param iv 指定矢量
     * @param text 加密前文字列
     * @return 加密后文字列
     */
    public static String encryptAES(String key, String iv, String text) {

        // 加密后文字列
        String strResult = null;

        try {
            byte[] byteText = text.getBytes(CHARACTER_TYPE);
            byte[] byteKey = key.getBytes(CHARACTER_TYPE);
            byte[] byteIv = iv.getBytes(CHARACTER_TYPE);

            // 密钥实例化
            SecretKeySpec keySpec = new SecretKeySpec(byteKey, "AES");
            // 矢量实例化
            IvParameterSpec ivSpec = new IvParameterSpec(byteIv);

            // Cipher的实例化及加密方式的填充
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // Cipher的初期化
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

            // 单部分加密数据操作
            byte[] byteResult = cipher.doFinal(byteText);

            // Base64加密
            // java8的情况使用如下。其他情况下请使用Commons Codec等
            strResult = Base64.getEncoder().encodeToString(byteResult);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        return strResult;
    }

    /**
     * 对称解密
     *
     * @param key 指定密钥
     * @param iv 指定矢量
     * @param text 解密前文字列
     * @return 解密后文字列
     */
    public static String decryptAES(String key, String iv, String text) {

        String strResult = null;

        try {
            // Base64加密
            // java8的情况使用如下。其他情况下请使用Commons Codec等
            byte[] byteText = Base64.getDecoder().decode(text);

            byte[] byteKey = key.getBytes("UTF-8");
            byte[] byteIv = iv.getBytes("UTF-8");

            // 密钥实例化
            SecretKeySpec keySpec = new SecretKeySpec(byteKey, "AES");
            // 矢量实例化
            IvParameterSpec ivSpec = new IvParameterSpec(byteIv);

            // Cipher的实例化及加密方式的填充
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // Cipher的初期化
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            // 单部分解密数据操作
            byte[] byteResult = cipher.doFinal(byteText);

            // byte转字符串
            strResult = new String(byteResult, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return strResult;
    }
}
