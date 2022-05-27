package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_18108 {
    public static void test() throws IOException {
        int diff = 2541 - 1998;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine().trim()) - diff);
    }
}
