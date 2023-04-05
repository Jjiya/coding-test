package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_23348 {
  // https://www.acmicpc.net/problem/23348
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] score = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    int n = Integer.parseInt(br.readLine());

    int maxCount = 0;
    int sum = 0;

    for (int i = 0; i < n * 3; i++) {
      st = new StringTokenizer(br.readLine());
      if (i != 0 && i % 3 == 0) {
        maxCount = Math.max(maxCount, sum);
        sum = 0;
      }

      for (int j = 0; j < 3; j++) {
        sum += (score[j] * Integer.parseInt(st.nextToken()));
      }
    }

    System.out.print(maxCount);
  }
}
