package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_2953 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    HashMap<Integer, Integer> scoreList = new HashMap<>();
    int maxScore = 0;

    for (int i = 1; i <= 5; i++) {
      st = new StringTokenizer(br.readLine());
      int score = 0;
      for (int j = 0; j < 4; j++) {
        score += Integer.parseInt(st.nextToken());
      }
      scoreList.put(score, i);
      maxScore = Math.max(maxScore, score);
    }

    System.out.print(scoreList.get(maxScore) + " " + maxScore);
  }
}
