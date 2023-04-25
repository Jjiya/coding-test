package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_4458 {
  // https://www.acmicpc.net/problem/4458
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String input = br.readLine();

      char first = input.charAt(0);
      if (97 <= first) {
        first -= 32;
      }

      System.out.println(first + input.substring(1));
    }
  }
}
