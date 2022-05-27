package com.codingTest.baekjoon.bronze.io;

import java.io.*;
import java.util.Arrays;

public class B_10430 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        int[] inputNum = Arrays.stream(input.split("\\s")).mapToInt(Integer::parseInt).toArray();
        int a = inputNum[0];
        int b = inputNum[1];
        int c = inputNum[2];

        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b % c)) % c);
        System.out.println((a * b) % c);
        System.out.println(((a % c) * (b % c)) % c);
    }
}
