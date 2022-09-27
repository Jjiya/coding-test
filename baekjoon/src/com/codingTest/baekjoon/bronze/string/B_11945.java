package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_11945 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String bread = br.readLine();
      for (int j = m - 1; j >= 0; j--) {
        sb.append(bread.charAt(j));
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
