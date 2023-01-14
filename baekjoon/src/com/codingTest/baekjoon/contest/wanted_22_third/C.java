package com.codingTest.baekjoon.contest.wanted_22_third;

import java.io.*;
import java.util.*;

// 미팅
public class C {
//  https://showmethecode.acmicpc.net/contest/problem/940/3
  static int[][] w;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    w = new int[c + 1][c + 1];

    int[] an = new int[Math.max(n, m)];
    int[] bm = new int[Math.max(n, m)];

    for (int i = 1; i <= c; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= c; j++) {
        w[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      an[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      bm[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[an.length + 1][2];
    /*
      dp[n][0] ==> 앞사람 or -1 사람과 악수
      dp[n][1] ==> 앞사람 or +1 사람과 악수
     */

    dp[1][0] = getW(an[1], bm[1]);
    dp[1][1] = getW(an[1], bm[2]);

    for (int i = 2; i <= an.length; i++) {
      dp[i][0] = Math.max(getW(an[i], bm[i]), getW(an[i], bm[i - 1]));
      dp[i][1] = Math.max(getW(an[i], bm[i]), getW(an[i], bm[i + 1]));
    }

    int sum1 = 0, sum2 = 0;

    for (int[] rs : dp) {
      sum1 += rs[0];
      sum2 += rs[1];
    }

    System.out.println(Math.max(sum1, sum2));
  }

  static int getW(int a, int b) {
    return Math.max(w[a][b], w[b][a]);
  }
}
