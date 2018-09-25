package com.yxb.util;

/**
 * Created by VMBing on 2017/3/8.
 */
public class StringUtil {
    /**
     * 判断内容是否为null或空
     * @param str 文本内容
     * @return 为null或空 true，反之 false
     */
    public static boolean isNullOrEmpty(String str) {
        boolean result = false;
        if (null == str || str.isEmpty()) {
            result = true;
        }
        return result;
    }
}
