package com.example.gankiomy;

/**
 * Created by guodazhao on 2018/2/26 0026.
 */
@Deprecated
public class UnicodeUtils {
    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
           char c= string.charAt(i);
            //转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * unicode转字符串
     */
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 0; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char)data);
        }
        return string.toString();
    }
}
