package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;
import java.util.StringTokenizer;

public class B_4344 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int c = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (0 < c) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int studentCount = Integer.parseInt(st.nextToken());

      int[] scoreList = new int[studentCount];

      int sum = 0;

      for (int i = 0; i < scoreList.length; i++) {
        int score = Integer.parseInt(st.nextToken());
        scoreList[i] = score;
        sum += score;
      }

      double avg = sum / studentCount;
      int count = 0;

      for (int i = 0; i < studentCount; i++) {
        if (avg < scoreList[i]) count++;
      }

      sb.append(String.format("%.3f", count / (double) studentCount * 100)).append("%").append("\n");

      c--;
    }

    System.out.print(sb);
  }
}
