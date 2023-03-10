package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_11256 {
  // https://www.acmicpc.net/problem/11256
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());

      int j = Integer.parseInt(st.nextToken()); // 사탕
      int n = Integer.parseInt(st.nextToken()); // 상자 개수

      int[] boxList = new int[n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        boxList[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
      }

      Arrays.sort(boxList);

      int boxIdx = n - 1;
      int boxCount = 0;

      while (0 <= boxIdx && j != 0) {
        j -= Math.min(boxList[boxIdx--], j);
        boxCount++;
      }

      sb.append(boxCount).append("\n");
    }

    System.out.print(sb);
  }
}
