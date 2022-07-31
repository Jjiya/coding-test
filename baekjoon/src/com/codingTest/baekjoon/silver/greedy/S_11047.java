package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_11047 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = convertInt(st.nextToken());
    int k = convertInt(st.nextToken());

    int[] coins = new int[n];

    for (int i = 0; i < n; i++) {
      coins[i] = convertInt(br.readLine());
    }

    int coinCount = n - 1;
    int count = 0;
    while (k > 0) {
      int number = k / coins[coinCount];
      count += number;
      k -= number * coins[coinCount];
      coinCount--;
    }

    System.out.print(count);
  }

  static int convertInt(String str) {
    return Integer.parseInt(str);
  }
}
