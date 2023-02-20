package com.codingTest.baekjoon.silver.math;

import java.io.*;
import java.util.StringTokenizer;

public class S_25206 {
  // https://www.acmicpc.net/problem/25206
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    float creditSum = 0;
    float sum = 0;

    for (int i = 0; i < 20; i++) {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      float credit = Float.parseFloat(st.nextToken());
      float grade = getScore(st.nextToken());

      if (grade == -1) {
        continue;
      }

      creditSum += credit;
      sum += (credit * grade);
    }

    System.out.printf("%6f", sum / creditSum);
  }

  static float getScore(String grade) {
    switch (grade) {
      case "A+":
        return 4.5f;
      case "A0":
        return 4.0f;
      case "B+":
        return 3.5f;
      case "B0":
        return 3.0f;
      case "C+":
        return 2.5f;
      case "C0":
        return 2.0f;
      case "D+":
        return 1.5f;
      case "D0":
        return 1.0f;
      case "F":
        return 0;
      default:
        return -1;
    }
  }
}
