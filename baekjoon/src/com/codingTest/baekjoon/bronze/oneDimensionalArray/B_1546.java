package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;
import java.util.StringTokenizer;

public class B_1546 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine().trim());

    int[] originalScoreArr = new int[n];
    int max = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int score = Integer.parseInt(st.nextToken());

      max = Math.max(max, score);
      originalScoreArr[i] = score;
    }

    double sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (((double) originalScoreArr[i] / max) * 100);
    }

    System.out.print(sum / n);
  }
}
