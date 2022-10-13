package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_2776 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      HashSet<Integer> memo1 = new HashSet<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        memo1.add(Integer.parseInt(st.nextToken()));
      }

      int m = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        if (memo1.contains(Integer.parseInt(st.nextToken()))) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      }
    }

    System.out.print(sb);
  }
}
