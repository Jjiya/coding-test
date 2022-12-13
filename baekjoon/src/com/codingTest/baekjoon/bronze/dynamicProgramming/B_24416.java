package com.codingTest.baekjoon.bronze.dynamicProgramming;

import java.io.*;

public class B_24416 {
  static int recursiveCount = 0;
  static int dpCount = 0;
  static int[] f;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    fib(n);

    System.out.print(recursiveCount + " " + (n - 2));
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    f = new int[n + 1];

    fib(n);
    fibonacci(n);

    System.out.print(recursiveCount + " " + dpCount);
  }

  static int fib(int n) {
    if (n <= 2) {
      recursiveCount++;
      return 1;
    }

    return fib(n - 1) + fib(n - 2);
  }

  static void fibonacci(int n) {
    f[1] = f[2] = 1;
    for (int i = 3; i <= n; i++) {
      dpCount++;
    }
  }
}
