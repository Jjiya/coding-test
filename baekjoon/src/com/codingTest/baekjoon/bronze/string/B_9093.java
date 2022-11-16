package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_9093 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        String str = st.nextToken();

        if (str.length() == 1) {
          sb.append(str);
        } else {
          for (int j = str.length() - 1; j >= 0; j--) {
            sb.append(str.charAt(j));
          }
        }

        sb.append(" ");
      }

      sb.append("\n");
    }

    System.out.print(sb);
  }
}
