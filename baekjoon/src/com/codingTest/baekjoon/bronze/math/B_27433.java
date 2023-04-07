package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_27433 {
  // https://www.acmicpc.net/problem/27433
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    long factorial = 1;
    for (int i = 2; i <= n; i++) {
      factorial *= i;
    }

    System.out.print(factorial);
  }
}
