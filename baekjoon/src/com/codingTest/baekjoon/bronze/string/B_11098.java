package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_11098 {
  // https://www.acmicpc.net/problem/11098
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      int p = Integer.parseInt(br.readLine());

      int max = 0;
      String maxName = null;

      StringTokenizer st;

      while (p-- > 0) {
        st = new StringTokenizer(br.readLine());

        int money = Integer.parseInt(st.nextToken());
        if (max < money) {
          max = money;
          maxName = st.nextToken();
        }
      }

      sb.append(maxName).append("\n");
    }

    System.out.print(sb);
  }
}
