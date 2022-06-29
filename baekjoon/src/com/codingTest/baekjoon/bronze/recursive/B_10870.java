package com.codingTest.baekjoon.bronze.recursive;

import java.io.*;

public class B_10870 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(fibonacci(Integer.parseInt(br.readLine())));
  }

  static int fibonacci(int index) {
    if (index == 0) return 0;
    else if (index == 1) return 1;
    else return fibonacci(index - 1) + fibonacci(index - 2);
  }
}