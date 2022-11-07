package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_5800 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= k; i++) {
      sb.append("Class ").append(i).append("\n");
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());

      int[] scoreList = new int[n];
      for (int j = 0; j < n; j++) {
        int score = Integer.parseInt(st.nextToken());
        scoreList[j] = score;
      }

      Arrays.sort(scoreList);
      int largestGap = scoreList[n - 1] - scoreList[n - 2];
      for (int j = n - 2; j > 0; j--) {
        largestGap = Math.max(largestGap, scoreList[j] - scoreList[j - 1]);
      }

      sb.append("Max " + scoreList[n - 1] + ", Min " + scoreList[0] + ", Largest gap " + largestGap + "\n");
    }

    System.out.println(sb);
  }
}
