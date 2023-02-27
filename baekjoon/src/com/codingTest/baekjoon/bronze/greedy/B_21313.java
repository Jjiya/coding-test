package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_21313 {
  // https://www.acmicpc.net/problem/21313
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < (n / 2); i++) {
        sb.append("1 2 ");
      }

      if (n % 2 == 1) {
        sb.append("3");
      }

      System.out.print(sb);
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] hand = new int[n];

      hand[0] = 1;

      for (int i = 1; i < n; i++) {
        int before = hand[i - 1];
        int after = hand[(i + 1) % n];

        for (int j = 1; j <= 8; j++) {
          if (before != j && after != j) {
            hand[i] = j;
            break;
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int rs : hand) {
        sb.append(rs).append(" ");
      }

      System.out.print(sb);
    }
  }
}
