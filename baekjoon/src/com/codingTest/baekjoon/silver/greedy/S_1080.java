package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_1080 {
  // https://www.acmicpc.net/problem/1080
  static final int FLIP_SIZE = 3;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][m];
    int[][] b = new int[n][m];

    boolean[][] isSame = new boolean[n][m];

    for (int i = 0; i < n * 2; i++) {
      char[] chars = br.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        int value = chars[j] - 48;

        if (i < n) {
          a[i][j] = value;
        } else {  // n번째 read부터는 b행렬에 저장
          b[i % n][j] = value;

          isSame[i % n][j] = (a[i % n][j] == b[i % n][j]);
        }
      }
    }

    int flipCount = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (n - FLIP_SIZE < i || m - FLIP_SIZE < j) {
          if (isSame[i][j]) {
            continue;
          } else {
            System.out.print(-1);
            return;
          }
        }

        if (!isSame[i][j]) {
          flipCount++;

          for (int k = i; k < Math.min(i + FLIP_SIZE, n); k++) {
            for (int l = j; l < Math.min(j + FLIP_SIZE, m); l++) {
              isSame[k][l] = !isSame[k][l];
            }
          }
        }
      }
    }

    System.out.print(flipCount);
  }
}
/*
1 2
00
01
=> -1

1 2
01
01
=> 0
 */