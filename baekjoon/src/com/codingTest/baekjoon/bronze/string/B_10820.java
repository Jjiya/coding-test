package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_10820 {
  // https://www.acmicpc.net/problem/10820
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    StringBuilder sb = new StringBuilder();

    while ((input = br.readLine()) != null) {
      int[] count = new int[4];

      for (char letter : input.toCharArray()) {
        if ('a' <= letter && letter <= 'z') {
          count[0]++;
        } else if ('A' <= letter && letter <= 'Z') {
          count[1]++;
        } else if ('0' <= letter && letter <= '9') {
          count[2]++;
        } else {
          count[3]++;
        }
      }

      for (int c : count) {
        sb.append(c).append(" ");
      }

      sb.append("\n");
    }

    System.out.print(sb);
  }
}