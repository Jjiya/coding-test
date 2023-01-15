package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_14659 {
  // https://www.acmicpc.net/problem/14659
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] height = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    int attackIdx = 0, maxCount = 0, count = 0;

    for (int i = 0; i < n; i++) {
      height[i] = Integer.parseInt(st.nextToken());

      if (i == attackIdx) continue;

      if (height[i] < height[attackIdx]) {
        count++;
      } else {
        attackIdx = i;
        count = 0;
      }

      maxCount = Math.max(maxCount, count);
    }

    System.out.print(maxCount);
  }
}
