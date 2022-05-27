package com.codingTest.baekjoon.bronze.io;

import java.util.Date;

//https://www.acmicpc.net/problem/25083
public class B_25083 {
    public static void test() {
        String[] sprout = {
                "         ,r'\"7",
                "r`-_   ,'  ,/",
                " \\. \". L_r'",
                "   `~\\/",
                "      |",
                "      |"
        };
        System.out.println(new Date());
        for (int i = 0; i < sprout.length; i++) {
            System.out.println(sprout[i]);
        }
        System.out.println(new Date() + "-----------\n");

        System.out.println(
                "         ,r'\"7\n" +
                        "r`-_   ,'  ,/\n" +
                        " \\. \". L_r'\n" +
                        "   `~\\/\n" +
                        "      |\n" +
                        "      |"
        );
        System.out.println(new Date());
    }
}
