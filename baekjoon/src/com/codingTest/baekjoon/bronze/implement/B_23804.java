package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_23804 {
  // https://www.acmicpc.net/problem/23804
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    sb.append(appendAtSign(n, n * 5));
    sb.append(appendAtSign(n * 5 - (n * 2), n));
    sb.append(appendAtSign(n, n * 5));

    System.out.print(sb);
  }

  static StringBuilder appendAtSign(int maxI, int maxJ) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxI; i++) {
      for (int j = 0; j < maxJ; j++) {
        sb.append("@");
      }
      sb.append("\n");
    }

    return sb;
  }
}
