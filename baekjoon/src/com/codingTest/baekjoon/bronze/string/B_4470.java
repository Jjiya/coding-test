package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_4470 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder(n);

    for (int i = 1; i <= n; i++) {
      sb.append(i).append(". ").append(br.readLine()).append("\n");
    }

    System.out.print(sb);
  }
}
