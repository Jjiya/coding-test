package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_2857 {
  // https://www.acmicpc.net/problem/2857
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 5; i++) {
      if (br.readLine().contains("FBI")) {
        sb.append(i).append(" ");
      }
    }

    if (sb.length() == 0) {
      System.out.print("HE GOT AWAY!");
    } else {
      System.out.print(sb);
    }
  }
}
