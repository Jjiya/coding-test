package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_1547 {
  // https://www.acmicpc.net/problem/1547
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());

    int[] cup = new int[4];

    cup[1] = 1;

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int sub = cup[x];
      cup[x] = cup[y];
      cup[y] = sub;
    }

    for (int i = 1; i < 4; i++) {
      if (cup[i] == 1) {
        System.out.print(i);
        return;
      }
    }

    System.out.print(-1);
  }
}
