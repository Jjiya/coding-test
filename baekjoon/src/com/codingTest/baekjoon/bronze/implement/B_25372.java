package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_25372 {
  // https://www.acmicpc.net/problem/25372
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (n-- > 0) {
      int passwordLength = br.readLine().length();

      sb.append((6 <= passwordLength && passwordLength <= 9) ? "yes" : "no").append("\n");
    }

    System.out.print(sb);
  }
}
