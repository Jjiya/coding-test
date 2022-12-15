package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_1085 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int min = 1001;
    int[] dist = new int[4];

    for (int i = 0; i < 4; i++) {
      dist[i] = Integer.parseInt(st.nextToken());
      min = Math.min(min, dist[i]);
    }

    for (int i = 0; i < 2; i++) {
      min = Math.min(min, Math.abs(dist[i] - dist[i + 2]));
    }

    System.out.print(min);
  }
}
