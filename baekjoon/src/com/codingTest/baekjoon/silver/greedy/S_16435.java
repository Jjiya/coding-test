package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_16435 {
  // https://www.acmicpc.net/problem/16435
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int[] fruit = new int[n];

    for (int i = 0; i < n; i++) {
      fruit[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(fruit);

    if (m < fruit[0]) {
      System.out.print(m);
      return;
    }

    m++;

    for (int i = 1; i < n; i++) {
      if (m < fruit[i]) {
        System.out.print(m);
        return;
      }

      m++;
    }

    System.out.print(m);
  }
}
/*
4 10
9 10 11 13
=> 14
*/