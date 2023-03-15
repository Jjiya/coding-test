package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_25314 {
  // https://www.acmicpc.net/problem/25314
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n / 4; i++) {
      sb.append("long ");
    }
    sb.append("int");

    System.out.print(sb);
  }
}
