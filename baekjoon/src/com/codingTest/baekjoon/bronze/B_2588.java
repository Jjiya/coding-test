package com.codingTest.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;

public class B_2588 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inputs = new ArrayList<>();
        ArrayList<Integer> splitNum = new ArrayList<>();
        String tmp = "";

        while ((tmp = br.readLine().trim()) != null) {
            int tmpNum = Integer.parseInt(tmp);
            inputs.add(tmpNum);
        }
//        한글자씩 잘라서 곱하는거 해야함


    }
}
