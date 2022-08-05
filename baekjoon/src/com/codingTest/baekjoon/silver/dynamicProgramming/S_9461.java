package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_9461 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] pn = new long[101];
    pn[1] = 1;
    pn[2] = 1;

    for (int i = 3; i < pn.length; i++) {
      pn[i] = pn[i - 2] + pn[i - 3];
    }

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      sb.append(pn[n]).append("\n");
    }

    System.out.print(sb);
  }
}
