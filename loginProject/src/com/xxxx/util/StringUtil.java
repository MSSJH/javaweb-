package com.xxxx.util;
/**
 * 字符串工具类
 * **/
public class StringUtil {
        /**
         * 判断字符串是否为空
         *      如果为空 返还true，
         *      如果不为空，返还fales
         * **/
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

}
