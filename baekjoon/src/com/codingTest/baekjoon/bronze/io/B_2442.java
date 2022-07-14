package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_2442 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int maxWidth = n * 2 - 1;

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= maxWidth; i += 2) {
      int startIdx = (maxWidth - i) / 2;
      for (int j = 0; j < startIdx + i; j++) {
        sb.append((startIdx <= j) ? "*" : " ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
