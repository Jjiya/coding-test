package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_4796 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int idx = 1;
    while (!(input = br.readLine()).equals("0 0 0")) {
      st = new StringTokenizer(input);
      int l = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      int availableDays = Math.min(v % p, l); // 나머지가 l보다 더 클 수도 있기 때문에
      availableDays += (v/p) * l;

      sb.append("Case ").append(idx).append(": ").append(availableDays).append("\n");
      idx++;
    }

    System.out.print(sb);
  }
}
