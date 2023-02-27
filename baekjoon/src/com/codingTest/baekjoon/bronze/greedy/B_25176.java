package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_25176 {
  // https://www.acmicpc.net/problem/25176
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int count = 1;

    for (int i = 2; i <= n; i++) {
      count *= i;
    }

    System.out.print(count);
  }
}
