package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_11720 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] inputs = br.readLine().split("");
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += Integer.parseInt(inputs[i]);
    }
    System.out.print(sum);
  }
}
