package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_23969 {
  // https://www.acmicpc.net/problem/23969
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int aLength = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[aLength];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < aLength; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = aLength - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
          k--;
        }

        if (k == 0) {
          StringBuilder sb = new StringBuilder();
          for (int element : a) {
            sb.append(element).append(" ");
          }

          System.out.print(sb);
          return;
        }
      }
    }

    System.out.println(-1);
  }
}
