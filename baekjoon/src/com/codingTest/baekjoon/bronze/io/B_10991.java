package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_10991 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(" ".repeat(n - i))
          .append(printStar(i))
          .append("\n");
    }
    System.out.print(sb);
  }

  String printStar(int count) {
    StringBuilder sub = new StringBuilder();

    for (int i = 0; i < count * 2 - 1; i++) {
      sub.append(i % 2 == 0 ? "*" : " ");
    }
    return sub.toString();
  }
}
