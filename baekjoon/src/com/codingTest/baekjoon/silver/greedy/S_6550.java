package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_6550 {
  // https://www.acmicpc.net/problem/6550
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    outer:
    while ((input = br.readLine()) != null) {
      st = new StringTokenizer(input);

      String s = st.nextToken();
      String t = st.nextToken();

      int idx = 0;

      for (int i = 0; i < t.length(); i++) {
        if (t.charAt(i) == s.charAt(idx)) {
          idx++;
        }

        if (idx == s.length()) {
          sb.append("Yes\n");
          continue outer;
        }
      }

      sb.append("No\n");
    }

    System.out.print(sb);
  }
}
