package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;
import java.util.Arrays;
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

      double avg = 0;

      for (int i = 0; i < scoreList.length; i++) {
        int score = Integer.parseInt(st.nextToken());
        scoreList[i] = score;
        avg += (double) score / studentCount;
      }

      double finalAvg = avg;
      double ratio = Arrays.stream(scoreList).filter(score -> finalAvg < score).toArray().length / (double) studentCount * 100;

      sb.append(String.format("%.3f", ratio)).append("%").append("\n");

      c--;
    }

    System.out.print(sb);
  }
}
