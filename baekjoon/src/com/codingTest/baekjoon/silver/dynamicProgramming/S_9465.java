package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_9465 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = parseInt(br);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int n = parseInt(br);
      int[][] dp = new int[2][n + 1];  // 최대값 저장
      int[][] stickers = new int[2][n + 1];   // 스티커 저장

//      스티커 값 배열로 변경
      for (int j = 0; j < 2; j++) {
        int k = 1;
        for (String value : br.readLine().split("\\s")) {
          stickers[j][k++] = parseInt(value);
        }
      }

      dp[0][1] = stickers[0][1];
      dp[1][1] = stickers[1][1];

//      최대 값 구하기
      for (int j = 2; j <= n; j++) {
        dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
        dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
      }

      sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
    }

    System.out.print(sb);
  }

//  static int getMaxPicksValue() {
//    int sum = 0;
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 2; j++) {
//        int k;
//        if (i % 2 == 0) {
//          k = (j % 2 == 0) ? 0 : 1;
//        } else {
//          k = (j % 2 == 0) ? 1 : 0;
//        }
//        while (k < stickers[0].length) {
//          int pick_1 = stickers[j][k];
//          int pick_2 = stickers[j][k];
////          sum += Math.max()
//
//          k += 2;
//        }
//      }
//    }
//    return sum;
//  }

  static int parseInt(BufferedReader br) {
    try {
      return Integer.parseInt(br.readLine());
    } catch (IOException e) {
      return -1;
    }
  }

  static int parseInt(String str) {
    return Integer.parseInt(str);
  }
}
