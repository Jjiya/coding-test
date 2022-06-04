package com.codingTest.baekjoon.bronze.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10951 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String tmp = "";
    while ((tmp = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(tmp);
      sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
    }

    System.out.print(sb);
  }
}