package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

// TODO: 다시 풀어보기
public class S_14501 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] consulting = new int[n + 1][n + 1];
    int[] dp = new int[n + 2];

    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int t = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      consulting[i][0] = t;
      consulting[i][1] = p;
    }

    for (int i = n; i > 0; i--) {
      if (i + consulting[i][0] > n + 1) {
        dp[i] = dp[i + 1];
      }else {
        dp[i] = Math.max(dp[i + 1], consulting[i][1] + dp[i + consulting[i][0]]);
      }
    }

    System.out.print(dp[1]);
  }
}
