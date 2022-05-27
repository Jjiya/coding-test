package com.codingTest.baekjoon.bronze.io;

import java.io.*;
import java.util.Arrays;

public class B_10869 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split("\\s");
        int[] inputToNumber = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println(inputToNumber[0] + inputToNumber[1]);
        System.out.println(inputToNumber[0] - inputToNumber[1]);
        System.out.println(inputToNumber[0] * inputToNumber[1]);
        System.out.println(inputToNumber[0] / inputToNumber[1]);
        System.out.println(inputToNumber[0] % inputToNumber[1]);
    }
}
