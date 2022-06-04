package com.codingTest.baekjoon.bronze.loop;

import java.io.*;
import java.util.StringTokenizer;

public class B_15552 {
  public static void test() throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
    }

    System.out.print(sb);
  }

  public static void test1() throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < t; i++) {
      String[] inputs = br.readLine().trim().split("\\s");
      sb.append(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])).append("\n");
    }

    System.out.print(sb);
  }

  public static void test2() throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String tmp = "";

    while ((tmp = br.readLine()) != null) {
      if (tmp.equals("s")) break;

      String[] inputs = tmp.trim().split("\\s");
      if (inputs.length < 2) continue;

      sb.append(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])).append("\n");
    }

    System.out.print(sb);
  }
}
