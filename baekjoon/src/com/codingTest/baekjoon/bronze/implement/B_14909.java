package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_14909 {
  // https://www.acmicpc.net/problem/14909
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int count = 0;

    while (st.hasMoreTokens()) {
      if (0 < Integer.parseInt(st.nextToken())) {
        count++;
      }
    }

    System.out.print(count);
  }
}
