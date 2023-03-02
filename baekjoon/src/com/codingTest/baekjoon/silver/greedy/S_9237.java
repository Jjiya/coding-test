package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_9237 {
  // https://www.acmicpc.net/problem/9237
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] treeList = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      treeList[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(treeList);

    int max = 0;

    for (int i = n - 1, day = 2; i >= 0; i--, day++) {
      max = Math.max(max, treeList[i] + day);
    }

    System.out.print(max);
  }
}
