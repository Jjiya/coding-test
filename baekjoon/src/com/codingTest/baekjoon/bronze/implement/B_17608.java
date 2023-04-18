package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_17608 {
  // https://www.acmicpc.net/problem/17608
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] stick = new int[n];

    for (int i = 0; i < n; i++) {
      stick[i] = Integer.parseInt(br.readLine());
    }

    int base = stick[n - 1];
    int count = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (base < stick[i]) {
        count++;
        base = stick[i];
      }
    }

    System.out.print(count);
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] stick = new int[n];

      for (int i = 0; i < n; i++) {
        stick[i] = Integer.parseInt(br.readLine());
      }

      int base = stick[n - 1];
      int count = 1;
      for (int i = n - 2; i >= 0; i--) {
        if (base < stick[i]) {
          count++;
        }
      }

      System.out.print(count);
    }
  }
}
