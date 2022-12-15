package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_2609 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split("\\s");

    int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
    int gcd = (gcd(a, b));

    System.out.println(gcd);
    System.out.print((a * b) / gcd);
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
