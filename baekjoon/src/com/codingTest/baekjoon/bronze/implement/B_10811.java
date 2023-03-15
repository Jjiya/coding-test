package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_10811 {
  // https://www.acmicpc.net/problem/10811
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] basket = new int[n];

    for (int i = 0; i < n; i++) {
      basket[i] = i + 1;
    }

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      int middle = (i + j) / 2;

//      역순은 대칭되는 값을 바꾸는 것임
      for (int k = i - 1; k < middle; k++) {
        int tmp = basket[k];

        basket[k] = basket[--j];
        basket[j] = tmp;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : basket) {
      sb.append(num).append(" ");
    }

    System.out.print(sb);
  }
}
