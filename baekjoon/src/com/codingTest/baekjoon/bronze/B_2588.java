package com.codingTest.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;

public class B_2588 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> inputs = new ArrayList<>();
        String tmp = "";

        while ((tmp = br.readLine()) != null) {
            inputs.add(tmp);
        }

        char[] charList = inputs.get(1).toCharArray();
        int idx = charList.length;
        int[] splitNums = new int[idx];

        for (char charNum : charList) {
            splitNums[--idx] = Integer.parseInt(String.valueOf(charNum));
        }

        int firstNum = Integer.parseInt(inputs.get(0));
        for (int num : splitNums) {
            System.out.println(firstNum * num);
        }
        System.out.print(firstNum * Integer.parseInt(inputs.get(1)));
    }
}
