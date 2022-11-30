package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_2579 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int stepCount = Integer.parseInt(br.readLine());

    int[] score = new int[stepCount + 1];

    for (int i = 1; i <= stepCount; i++) {
      score[i] = Integer.parseInt(br.readLine());
    }

/*
  해당 분기분을 넣어주지 않으면
  dp배열 초기화 시 오류가 발생함.

  1. dp 배열을 최대 계단의 수로 만들든지
  2. 아래처럼 if 분기 문을 넣어주든지
 */
    if (stepCount == 1) {
      System.out.print(score[1]);
      return;
    }

    int[] dp = new int[stepCount + 1];

    dp[1] = score[1];
    dp[2] = score[1] + score[2];

    for (int i = 3; i <= stepCount; i++) {
      /*
       * 현재 계단의 최대 값은
       * 1. 연속되지 않은 계단의 최대값과 현재 계단 점수를 더함
       * 2. 연속된 계단을 밟고, 그 밟은 계단과 연속되지 않은 계단의 최대값 점수 + 현재 계단 점수를 더함
       */
      dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
    }

    System.out.print(dp[stepCount]);
  }
}
