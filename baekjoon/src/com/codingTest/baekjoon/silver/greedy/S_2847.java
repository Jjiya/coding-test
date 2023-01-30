package com.codingTest.baekjoon.silver.greedy;

import java.io.*;

public class S_2847 {
  // https://www.acmicpc.net/problem/2847
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] score = new int[n];

    for (int i = 0; i < n; i++) {
      score[i] = Integer.parseInt(br.readLine());
    }

    int reduction = 0;

    for (int i = n - 2; i >= 0; i--) {
      int diff = score[i + 1] - score[i];

      if (0 < diff) {
        continue;
      }

      diff = (diff * -1) + 1;
      reduction += diff;

      score[i] -= diff;
    }

    System.out.print(reduction);
  }
}
