package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_2903 {
  // https://www.acmicpc.net/problem/2903
//  TODO: 다시 풀어보기...
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] dot = new int[16];

    int sqrt = 2;
    for (int i = 0; i <= n; i++) {
      dot[i] = sqrt * sqrt;
      sqrt = sqrt + (sqrt - 1);
    }

    System.out.println(dot[n]);
  }
}
