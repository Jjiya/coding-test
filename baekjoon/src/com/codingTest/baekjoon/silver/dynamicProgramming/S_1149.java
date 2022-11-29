package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 처음에는 dp를 1차원 배열로 풀려고 했다.
 * 그렇게 하니까 현재 칠할 집의 index가 앞의 집에서 칠한 index와 같은지 비교하는 작업을 했어야 했다.
 * 그래서 찾아보니 각각의 경우의 수를 dp에 저장해주었다...
 * dp를 꼭 1차원 배열로 풀어야한다는 편견이 있었던 것 같음
 * 그리고 하단의 n번째 dp의 min값을 구할때 숫자를 너무 작게 잡아서 틀렸다고 떴었음.
 * 집을 칠하는 비용은 최대 1000이기 때문에 최대값 1000이 n번 나올 경우의 수 +1을 하면 답을 제대로 구할 수 있게 된다...
 * 범위 잘 잡기!!
 */
public class S_1149 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n + 1][3];
    int[][] house = new int[n + 1][3];
    StringTokenizer st;

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 3; j++) {
        house[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
    }

    int min = 1000 * n + 1;
    for (int i = 0; i < 3; i++) {
      min = Math.min(min, dp[n][i]);
    }

    System.out.print(min);
  }
}
