package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_10950 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = "";
        String sumResult = "";
        
        while ((tmp = br.readLine()) != null) {
            if (tmp.equals("s")) break;

            String[] inputs = tmp.trim().split("\\s");
            if (inputs.length < 2) continue;

            sumResult += Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]) + "\n";
        }
        System.out.print(sumResult);
    }
}
