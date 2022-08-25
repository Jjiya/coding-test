package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;

public class B_2748 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print(getFibonacci(Integer.parseInt(br.readLine())));
  }

  static long getFibonacci(int i) {
    if (i == 0) return 0;
    if (i == 1) return 1;

    return getFibonacci(i - 1) + getFibonacci(i - 2);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    long[] fibonacci = new long[n + 1];
    fibonacci[1] = 1;

    for (int i = 2; i <= n; i++) {
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    System.out.print(fibonacci[n]);
  }
}
