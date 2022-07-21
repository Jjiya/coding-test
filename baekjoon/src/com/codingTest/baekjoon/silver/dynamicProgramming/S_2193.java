package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_2193 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] pinaryNumber = new long[91]; //int로 하면 범위 초과로 인해 문제 틀림
    pinaryNumber[1] = 1;
    pinaryNumber[2] = 1;

    for (int i = 3; i <= n; i++) {
      pinaryNumber[i] = pinaryNumber[i - 1] + pinaryNumber[i - 2];
    }

    System.out.print(pinaryNumber[n]);
  }
}
