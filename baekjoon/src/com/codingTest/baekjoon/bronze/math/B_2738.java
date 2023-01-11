package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_2738 {
  // https://www.acmicpc.net/problem/2738
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] sum = new int[n][m];

    for (int i = 0; i < n * 2; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        sum[i % n][j] += Integer.parseInt(st.nextToken());
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(sum[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
