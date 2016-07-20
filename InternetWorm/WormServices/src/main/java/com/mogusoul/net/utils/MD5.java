package com.mogusoul.net.utils;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2016/7/19.
 */
public class MD5 {

    /**
     * 计算MD5信息摘要.
     * @param buffer
     * @return
     */
    public final static String getMessageDigest(byte[] buffer) {

        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(buffer);

            byte[] digest = instance.digest();

            return new String(Hex.encodeHex(digest,false));
        } catch (Exception e) {
            return null;
        }
    }






}
