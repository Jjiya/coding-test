package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_4504 {
  // https://www.acmicpc.net/problem/4504
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String input;

    StringBuilder sb = new StringBuilder();

    while (!(input = br.readLine()).equals("0")) {
      int number = Integer.parseInt(input);

      sb.append(number);

      if (number % n == 0) {
        sb.append(" is a multiple of ");
      } else {
        sb.append(" is NOT a multiple of ");
      }

      sb.append(n).append(".\n");
    }

    System.out.print(sb);
  }
}
