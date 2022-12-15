package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_3003 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] chess = {1, 1, 2, 2, 2, 8};

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chess.length; i++) {
      sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
    }

    System.out.print(sb);
  }
}
