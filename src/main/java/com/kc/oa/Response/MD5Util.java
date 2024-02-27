package com.kc.oa.Response;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

public class MD5Util {
        public static String encrypt(String input) {
            return DigestUtils.md5Hex(input);
        }

}

