package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_2741 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer n = Integer.parseInt(br.readLine().trim());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      sb.append(i).append("\n");
    }

    System.out.print(sb);
  }
}
