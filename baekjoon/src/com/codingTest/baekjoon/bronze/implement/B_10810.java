package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_10810 {
  // https://www.acmicpc.net/problem/10810
  public static void test() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] basket = new int[n];

    while(m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      for (; i <= j; i++) {
        basket[i - 1] = k;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : basket) {
      sb.append(num).append(" ");
    }

    System.out.print(sb);
  }
}
