package com.codingTest.baekjoon.silver.greedy;

import java.io.*;

public class S_1789 {
  // https://www.acmicpc.net/problem/1789
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());

    long count = 0, sum = 0, num = 1;

    while (sum <= n && sum + num <= n) {
      sum += num++;
      count++;
    }

    System.out.print(count);
  }
}
