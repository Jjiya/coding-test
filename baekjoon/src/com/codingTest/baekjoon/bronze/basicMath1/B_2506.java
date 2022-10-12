package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class B_2506 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int score = 0;
    int correctCount = 1;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      if (Integer.parseInt(st.nextToken()) == 1) {
        score += correctCount;
        correctCount++;
      } else {
        correctCount = 1;
      }
    }
    System.out.println(score);
  }
}
