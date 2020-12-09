package com.guyu.bdcwxsubscription.utils;

import java.security.MessageDigest;

/**
 * @创建人 黄盼
 * @创建时间 15:58
 * @描述
 **/
public class MyMD5Util {
    //加密尾椎
    private static String fh = ".?%&?";

    /***
     * MD5加密
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 复杂加密
     *
     * @param inStr
     * @return
     */
    public static String JM(String inStr, String loginname) {
        return string2MD5(inStr + loginname + fh);
    }


    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
}
