package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_3058 {
  // https://www.acmicpc.net/problem/3058
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());

      int sum = 0;
      int min = 101;

      for (int i = 0; i < 7; i++) {
        int num = Integer.parseInt(st.nextToken());

        if (num % 2 == 0) {
          sum += num;
          min = Math.min(min, num);
        }
      }

      sb.append(sum).append(" ").append(min).append("\n");
    }

    System.out.print(sb);
  }
}
