package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_2446 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max = 2 * n - 1;
    StringBuilder sb = new StringBuilder();

    int i = 1, subIndex = max;

    while (subIndex < max + 1) {
      if (subIndex < max) {
        sb.append(" ".repeat((max - subIndex) / 2));
      }
      sb.append("*".repeat(subIndex));
      sb.append("\n");
      if (i < n) {
        subIndex -= 2;
      } else {
        subIndex += 2;
      }
      i++;
    }
    System.out.print(sb);
  }
}