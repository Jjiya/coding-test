package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_2522 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n * 2 - 1; i++) {
      for (int j = 0; j < n; j++) {
        if (i <= n) {
          sb.append(n - i <= j ? "*" : " ");
        } else {
          sb.append(i % n <= j ? "*" : " ");
        }
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
