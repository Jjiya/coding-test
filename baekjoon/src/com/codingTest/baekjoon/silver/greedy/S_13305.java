package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_13305 {
  // https://www.acmicpc.net/problem/13305
  //  참고: https://excited-hyun.tistory.com/71
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] roadLength = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      roadLength[i] = Integer.parseInt(st.nextToken());
    }

    int[] oilPrice = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      oilPrice[i] = Integer.parseInt(st.nextToken());
    }

    long minCost = oilPrice[0];
    long sum = minCost * roadLength[0];

    for (int i = 1; i < n - 1; i++) {
      minCost = Math.min(minCost, oilPrice[i]);

      sum += minCost * roadLength[i];
    }

    System.out.print(sum);
  }
}
