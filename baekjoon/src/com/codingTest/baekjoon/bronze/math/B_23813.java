package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_23813 {
  // https://www.acmicpc.net/problem/23813
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String n = br.readLine();
    int copy = Integer.parseInt(n);

    long sum = 0;

    for (int i = 0; i < n.length(); i++) {
      sum += copy;

      int moving = (copy % 10) * (int) Math.pow(10, n.length() - 1);
      copy = copy / 10 + moving;
    }

    System.out.print(sum);
  }
}
