package com.codingTest.baekjoon.bronze;

import java.io.*;

public class B1008 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split("\\s");

        System.out.print(Double.parseDouble(input[0]) / Double.parseDouble(input[1]));
    }
}
