package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_3062 {
  // https://www.acmicpc.net/problem/3062
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());

      int sum = n + reverseNumber(n);

      sb.append(isPalindromeNumber(sum) ? "YES\n" : "NO\n");
    }

    System.out.print(sb);
  }

  static int reverseNumber(int n) {
    return Integer.parseInt(reverse(n));
  }

  static String reverse(int n) {
    return String.valueOf(new StringBuilder().append(n).reverse());
  }

  static boolean isPalindromeNumber(int sum) {
    return sum == reverseNumber(sum);
  }
}