package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;

public class B_8958 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int total = 0, cumulate = 0; // 문제를 연속적으로 맞힌 누적 값

      char[] quizResult = br.readLine().trim().toCharArray();

      for (int j = 0; j < quizResult.length; j++) {
        if (quizResult[j] == 'O') total += ++cumulate;
        else cumulate = 0;
      }

      sb.append(total).append("\n");
    }

    System.out.print(sb);
  }
}
