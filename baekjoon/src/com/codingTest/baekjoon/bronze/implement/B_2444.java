package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_2444 {
  // https://www.acmicpc.net/problem/2444
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        sb.append(" ");
      }
      for (int j = 0; j < i * 2 + 1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j < n - i - 1; j++) {
        sb.append(" ");
      }
      for (int j = 0; j < i * 2 + 1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
