package com.codingTest.baekjoon.WorldsBestContest6th;

import java.io.*;
import java.util.StringTokenizer;

public class A {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < testCase; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      double height = Double.parseDouble(st.nextToken());
      double weight = Double.parseDouble(st.nextToken());

      sb.append(getGrade(height, weight)).append("\n");
    }
    System.out.print(sb);
  }

  static int getGrade(double height, double weight) {
    if (height < 140.1) return 6;
    if (140.1 <= height && height < 146) return 5;
    if (146 <= height && height < 159) return 4;
    if (159 <= height && height < 161) {
      double bmi = getBMI(height, weight);
      if (16.0 <= bmi && bmi < 35.0) return 3;
      if (bmi < 16.0 || 35.0 <= bmi) return 4;
    }
    if (161 <= height && height < 204) {
      double bmi = getBMI(height, weight);
      if (20.0 <= bmi && bmi < 25.0) return 1;
      if ((18.5 <= bmi && bmi < 20.0) || (25.0 <= bmi && bmi < 30)) return 2;
      if ((16.0 <= bmi && bmi < 18.5) || (30.0 <= bmi && bmi < 35.0)) return 3;
      if ((20.0 <= bmi && bmi < 25.0) || (20.0 <= bmi && bmi < 25.0)) return 4;
      if (bmi < 16.0 || 35.0 <= bmi) return 4;
    }
    return 4;
  }

  static double getBMI(double height, double weight) {
    return weight / Math.pow(height / 100, 2);
  }
}
