package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_10822 {
  // https://www.acmicpc.net/problem/10822
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), ",");

    int sum = 0;
    while (st.hasMoreTokens()) {
      sum += Integer.parseInt(st.nextToken());
    }

    System.out.println(sum);
  }
}
