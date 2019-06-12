package com.exam.examsystem.utils;

import java.util.Random;

/**
 * @author: hongwei.wang
 * @create: 2019-06-12 17:22
 */
public class SlatUtils {


    public static final String CODES = "0123456789abcdefghijklmnopqrstuvwxyz";


    public static String generateVerifyCode() {
        int codesLen = CODES.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            verifyCode.append(CODES.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }

    public static void main(String[] args) {
        System.out.println(SlatUtils.generateVerifyCode());
    }

}
