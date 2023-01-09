package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;

public class S_2217 {
  // https://www.acmicpc.net/problem/2217
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] lope = new int[n];

    for (int i = 0; i < n; i++) {
      lope[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(lope);

    int maxWeight = 0;

    for (int i = 0; i < n; i++) {
//      루프의 최대 중량 * 현재 남은 루프의 개수(n개의 루프에서 i개를 제외함)
      maxWeight = Math.max(maxWeight, lope[i] * (n - i));
    }

    System.out.print(maxWeight);
  }
}