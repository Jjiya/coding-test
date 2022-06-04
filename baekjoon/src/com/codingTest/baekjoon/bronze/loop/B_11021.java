package com.codingTest.baekjoon.bronze.loop;

import java.io.*;
import java.util.StringTokenizer;

public class B_11021 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer t = Integer.parseInt(br.readLine().trim());

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      sb.append("Case #" + i + ": ").append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
    }

    System.out.print(sb);
  }
}
