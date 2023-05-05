package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_2495 {
  // https://www.acmicpc.net/problem/2495
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      String value = br.readLine();
      int max = 1;
      int count = 1;

      for (int j = 1; j < 8; j++) {
        if (value.charAt(j - 1) == value.charAt(j)) {
          count++;
        } else {
          max = Math.max(max, count);
          count = 1;
        }
      }

      max = Math.max(max, count);
      sb.append(max).append("\n");
    }

    System.out.print(sb);
  }
}
