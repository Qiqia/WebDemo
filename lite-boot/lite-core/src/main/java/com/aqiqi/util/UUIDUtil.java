package com.aqiqi.util;

import java.util.UUID;

/**
 * Created by zsl on 2019/1/22.
 */
public class UUIDUtil {
    /**
     * toHexString方法
     * @param uuid
     * @return
     */
    public static String directlyToString(UUID uuid) {
        return Long.toHexString(uuid.getMostSignificantBits()) + Long.toHexString(uuid.getLeastSignificantBits());
    }

    /**
     * arrayCopy方法
     * @param uuid
     * @return
     */
    public static String arrayCopyToString(UUID uuid) {
        char[] dest = new char[32];
        char[] src = uuid.toString().toCharArray();
        System.arraycopy(src, 0, dest, 0, 8);
        System.arraycopy(src, 9, dest, 8, 4);
        System.arraycopy(src, 14, dest, 12, 4);
        System.arraycopy(src, 19, dest, 16, 4);
        System.arraycopy(src, 24, dest, 20, 12);
        return new String(dest);
    }

    /**
     * subString方法
     * @param uuid
     * @return
     */
    public static String subStringToString(UUID uuid) {
        String src = uuid.toString();
        return src.substring(0, 8) + src.substring(9, 13) + src.substring(14, 18) + src.substring(19, 23) + src.substring(24, 36);
    }

    /**
     * forToString方法
     * @param uuid
     * @return
     */
    public static String forToString(UUID uuid) {
        char[] src = uuid.toString().toCharArray();
        char[] chars = new char[32];
        for (int i = 0, j = 0; i < src.length; i++) {
            char c = src[i];
            if ('-' != c) {
                chars[j++] = c;
            }
        }
        return new String(chars);
    }

    /**
     * 正则方式
     * @param uuid
     * @return
     */
    public static String replaceToString(UUID uuid) {
        return uuid.toString().replaceAll("-", "");
    }
}
