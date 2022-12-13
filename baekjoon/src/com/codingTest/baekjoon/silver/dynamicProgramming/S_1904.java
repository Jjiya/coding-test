package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_1904 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];

    if (n < 3) {
      System.out.print(n);
      return;
    }

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 15_746;
    }

    System.out.print(dp[n]);
  }
}
