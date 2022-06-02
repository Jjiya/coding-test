package com.codingTest.baekjoon.bronze.loop;

import java.io.*;
import java.util.StringTokenizer;

public class B_10952 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());

    while (a != 0) {
      sb.append(a + Integer.parseInt(st.nextToken())).append("\n");
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
    }
    System.out.print(sb);
  }
}
