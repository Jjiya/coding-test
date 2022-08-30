package com.codingTest.baekjoon.silver.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class S_2740 {
  /*
  행렬 n*m * 행렬 m*k = n*k
   */
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int an = Integer.parseInt(st.nextToken());
    int am = Integer.parseInt(st.nextToken());
    int[][] a = new int[an][am];

    for (int i = 0; i < an; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < am; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int bm = Integer.parseInt(st.nextToken());
    int bk = Integer.parseInt(st.nextToken());

    int[][] b = new int[bm][bk];
    for (int i = 0; i < bm; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < bk; j++) {
        b[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    StringBuilder sb = new StringBuilder();

    for (int n = 0; n < an; n++) {
      for (int i = 0; i < bk; i++) {
        int sum = 0;
        for (int j = 0; j < am; j++) {
          sum += (a[n][j] * b[j][i]);
        }
        sb.append(sum).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
