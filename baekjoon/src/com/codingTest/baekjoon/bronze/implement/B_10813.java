package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_10813 {
  // https://www.acmicpc.net/problem/10813
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] basket = new int[n];

    for (int i = 1; i <= n; i++) {
      basket[i - 1] = i;
    }

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());

      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      int i_tmp = basket[i - 1];
      basket[i - 1] = basket[j - 1];
      basket[j - 1] = i_tmp;
    }

    StringBuilder sb = new StringBuilder();
    for (int num : basket) {
      sb.append(num).append(" ");
    }

    System.out.print(sb);
  }
}
