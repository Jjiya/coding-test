package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.math.BigInteger;

public class B_5988 {
  // https://www.acmicpc.net/problem/5988
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      BigInteger k = new BigInteger(br.readLine());

      sb.append(k.testBit(0) ? "odd" : "even").append("\n");
    }

    System.out.print(sb);
  }
}