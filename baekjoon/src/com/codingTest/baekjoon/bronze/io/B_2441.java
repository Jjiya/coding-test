package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_2441 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = n; i > 0; i--) {
      for (int j = 0; j < n - i; j++) {
        sb.append(" ");
      }
      for (int j = 0; j < i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
