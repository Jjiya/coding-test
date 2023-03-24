package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_10797 {
  // https://www.acmicpc.net/problem/10797
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int count = 0;

    for (int i = 0; i < 5; i++) {
      if (n == Integer.parseInt(st.nextToken())) {
        count++;
      }
    }

    System.out.print(count);
  }
}
