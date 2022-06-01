package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_2439 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer input = Integer.parseInt(br.readLine().trim());

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= input; i++) {
      sb.append(" ".repeat(input - i));
      for (int j = 0; j < i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
