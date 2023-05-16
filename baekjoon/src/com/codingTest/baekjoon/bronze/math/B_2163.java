package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_2163 {
  // https://www.acmicpc.net/problem/2163
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    System.out.print((n * m) -1);
  }
}
