package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_2747 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] fibonacci = new long[n + 1];

    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for (int i = 2; i <= n; i++) {
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    System.out.print(fibonacci[n]);
  }
}
