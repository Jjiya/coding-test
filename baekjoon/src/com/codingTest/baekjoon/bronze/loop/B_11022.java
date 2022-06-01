package com.codingTest.baekjoon.bronze.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11022 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer t = Integer.parseInt(br.readLine().trim());

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append("Case #" + i + ": ").append(a + " + " + b + " = ").append(a + b).append("\n");
    }

    System.out.print(sb);
  }
}
