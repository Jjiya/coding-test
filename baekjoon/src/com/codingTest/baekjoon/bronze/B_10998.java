package com.codingTest.baekjoon.bronze;

import java.io.*;

public class B_10998 {
    public static void test() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        String[] input = br.readLine().trim().split("\\s");

        System.out.println(Integer.parseInt(input[0]) * Integer.parseInt(input[1]));
    }
}
