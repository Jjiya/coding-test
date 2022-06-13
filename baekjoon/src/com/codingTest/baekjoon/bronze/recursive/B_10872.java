package com.codingTest.baekjoon.bronze.recursive;

import java.io.*;

public class B_10872 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());

    System.out.print(factorial(input));
  }

  static int factorial(int num) {
    if (num == 0) return 1;
    return num * factorial(--num);
  }
}
