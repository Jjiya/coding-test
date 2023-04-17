package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_9085 {
  // https://www.acmicpc.net/problem/9085
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += Integer.parseInt(st.nextToken());
      }

      sb.append(sum).append("\n");
    }

    System.out.print(sb);
  }
}
