package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_11057 {
  static long[][] dp;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    dp = new long[n + 2][10];

    saveDpValues(n);

    System.out.print(getNthValues(n, 0));
  }

  static void saveDpValues(int n) {
    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < 10; j++) {
        dp[i][j] = (dp[i][j] + getNthValues(i - 1, j)) % 10007;
      }
    }
  }

  static long getNthValues(int i, int j) {
    long sum = 0;
    for (; j < 10; j++) {
      sum = (sum + dp[i][j]) % 10007;
    }

    return sum;
  }
}
