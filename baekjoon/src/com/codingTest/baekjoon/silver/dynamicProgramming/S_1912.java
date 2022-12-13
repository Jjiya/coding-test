package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class S_1912 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] sequence = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    int currentSum = -1001;
    int maximumSum = -1001;

    for (int num : sequence) {
      currentSum = Math.max(currentSum + num, num);
      maximumSum = Math.max(maximumSum, currentSum);
    }

    System.out.print(maximumSum);
  }
}
