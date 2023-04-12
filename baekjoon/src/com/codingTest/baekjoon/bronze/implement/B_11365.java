package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_11365 {
  // https://www.acmicpc.net/problem/11365
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;

    StringBuilder sb = new StringBuilder();
    StringBuilder subSb;

    while (!(input = br.readLine()).equals("END")) {
      subSb = new StringBuilder();
      subSb.append(input);
      sb.append(subSb.reverse()).append("\n");
    }

    System.out.print(sb);
  }
}
