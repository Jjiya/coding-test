package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1932 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] triangle = new int[n][n];

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < i + 1; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    /*
      max 값을 0으로 초기화 했을 시 정답이 틀림.
      삼각형 크기는 무조건 1이상이고, 삼각형을 이룬 수의 범위는 최소 0인데...

      => https://www.acmicpc.net/board/view/92112
      삼각형 크기 n이 1일 때 아래 for문이 작동하지 않아서 max 값이 갱신이 안되는 것이였따!!!
    */
    int max = triangle[0][0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {// 바로 위의 숫자
          triangle[i][j] += triangle[i - 1][j];
        } else {  // 바로 위의 숫자와 대각선 왼쪽의 숫자 중 큰 값을 더해 줌
          triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
        }
        max = Math.max(max, triangle[i][j]);
      }
    }

    /*
      max 값을 구하는 방식을 stream을 이용해 풀었더니 불필요한 탐색이 실행되어서 그런지
      약 200ms가 더 느렸음 (물론 채점 시간은 오차가 있을 수 있겠으나 꽤나 큰 차이임)
      System.out.print(Arrays.stream(triangle[n - 1]).max().getAsInt());
     */
    System.out.print(max);
  }

  /*
    제일 처음 풀었던 방식.
    420ms로 맞힌 사람 코드를 참고해서 수정한 test()함수에 비해 2배 느림
   */
  public void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] triangle = new int[n][];
    int[][] dp = new int[n][n];

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      triangle[i] = new int[i + 1];

      for (int j = 0; j < i + 1; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = triangle[0][0];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (isSetValue(i - 1, j, n)) { // 바로 위의 숫자
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
        }
        if (isSetValue(i - 1, j - 1, n)) { // 대각선 왼쪽의 숫자
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + triangle[i][j]);
        }
      }
    }

    System.out.print(Arrays.stream(dp[n - 1]).max().getAsInt());
  }

  static boolean isSetValue(int x, int y, int n) {
    return (0 <= x && x < n) && (0 <= y && y <= x);
  }
}
