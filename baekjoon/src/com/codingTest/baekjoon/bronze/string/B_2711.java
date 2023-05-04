package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_2711 {
  // https://www.acmicpc.net/problem/2711
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());

      String input = st.nextToken();

      for (int i = 0; i < input.length(); i++) {
        if (i + 1 != idx) {
          sb.append(input.charAt(i));
        }
      }

      sb.append("\n");
    }

    System.out.print(sb);
  }
}
