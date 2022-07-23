package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

//이해가는 설명: https://hgu-can.tistory.com/entry/C-백준-온라인-저지-10844번-쉬운-계단-수-풀이 [코딩 공부하는 코딩류:티스토리]
public class S_10844 {
  static long[][] dp;
  static long mod = 1000000000L;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    dp = new long[n + 1][10];
    saveDpValue(n);

    long sum = 0;
    for (int i = 0; i < 10; i++) {
      sum = (sum + dp[n][i]) % mod;
    }

    System.out.print(sum);
  }

  static void saveDpValue(int n) {
    for (int i = 1; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < 10; j++) {
        if (j == 0) {
          dp[i][j] = (dp[i - 1][1]) % mod;
        } else if (j == 9) {
          dp[i][j] = (dp[i - 1][8]) % mod;
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
        }
      }
    }
  }
}
