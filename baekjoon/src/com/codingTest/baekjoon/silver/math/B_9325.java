package com.codingTest.baekjoon.silver.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_9325 {
  // https://www.acmicpc.net/problem/9325
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while (t-- > 0) {
      int s = Integer.parseInt(br.readLine());

      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());

        s +=( Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
      }

      sb.append(s).append("\n");
    }

    System.out.print(sb);
  }
}
