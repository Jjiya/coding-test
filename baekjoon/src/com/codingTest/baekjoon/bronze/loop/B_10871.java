package com.codingTest.baekjoon.bronze.loop;

import java.io.*;
import java.util.StringTokenizer;

public class B_10871 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer inputs = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(inputs.nextToken());
    int x = Integer.parseInt(inputs.nextToken());

    StringTokenizer input = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(input.nextToken());
      if (num < x) sb.append(num).append(" ");
    }

    System.out.print(sb);
  }
}
