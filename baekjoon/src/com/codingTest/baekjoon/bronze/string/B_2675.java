package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_2675 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      short r = Short.parseShort(st.nextToken());
      String[] s = st.nextToken().split("");

      for (int j = 0; j < s.length; j++) {
        sb.append(s[j].repeat(r));
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
