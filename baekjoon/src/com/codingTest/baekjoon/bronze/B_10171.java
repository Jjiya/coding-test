package com.codingTest.baekjoon.bronze;

//https://www.acmicpc.net/problem/10171
public class B_10171 {
    public static void test() {
        int maxLength = " )  ( ')".length();

        String[] cat = {
                "\\    /\\",
                " )  ( ')",
                "(  /  )",
                " \\(__)|"
        };

        for (int i = 0; i < cat.length; i++) {
            System.out.println(String.format("%-" + maxLength + "s", cat[i]));
        }
    }
}
