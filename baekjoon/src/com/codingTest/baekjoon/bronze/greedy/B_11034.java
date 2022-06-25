package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_11034 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = "";
    StringBuilder sb = new StringBuilder();
    while ((str = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(str);

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      sb.append(Math.max(b - a - 1, c - b - 1)).append("\n");
    }
    System.out.print(sb);
  }
}
