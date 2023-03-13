package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_11382 {
  // https://www.acmicpc.net/problem/11382
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());

    System.out.print(a + b + c);
  }
}
