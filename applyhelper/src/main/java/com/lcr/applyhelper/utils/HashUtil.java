package com.lcr.applyhelper.utils;

public class HashUtil {

    /**
     * 根据url，获取hex string representation
     * @param hash
     * @return String
     */
    public static String bytesToHex(byte[] hash) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            if ((0xFF & hash[i]) < 0x10) {
                stringBuilder.append("0" + Integer.toHexString((0xFF & hash[i])));
            } else {
                stringBuilder.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return stringBuilder.toString();
    }
}