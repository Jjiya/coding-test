package com.codingTest.baekjoon.silver.cumulativeSum;

import java.io.*;
import java.util.StringTokenizer;

public class S_11659 {
  /*
  각 구간별 합 구해놓고
  앞의 범위만큼 빼주기!
   */
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] cumulativeSum = new long[n + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      cumulativeSum[i] = cumulativeSum[i - 1] + Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      sb.append(cumulativeSum[end] - cumulativeSum[start - 1]).append("\n");
    }

    System.out.println(sb);
  }
}
