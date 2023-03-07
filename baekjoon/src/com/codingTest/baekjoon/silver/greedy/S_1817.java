package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_1817 {
  // https://www.acmicpc.net/problem/1817
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    if (n == 0) {
      System.out.print(0);
      return;
    }

    int restWeight = m;
    int boxCount = 1;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int bookWeight = Integer.parseInt(st.nextToken());

      if (restWeight - bookWeight < 0) {
        boxCount++;
        restWeight = m - bookWeight;
      } else {
        restWeight -= bookWeight;
      }
    }

    System.out.print(boxCount);
  }
}
