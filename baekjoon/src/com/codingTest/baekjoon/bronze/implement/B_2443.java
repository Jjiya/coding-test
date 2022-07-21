package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_2443 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max = 2 * n - 1;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= max - i; j++) {
        sb.append(j <= i ? " " : "*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}