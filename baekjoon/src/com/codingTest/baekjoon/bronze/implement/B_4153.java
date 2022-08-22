package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_4153 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    int[] triangle = new int[3];

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (!(input = br.readLine()).equals("0 0 0")) {
      st = new StringTokenizer(input);

      for (int i = 0; i < 3; i++) {
        triangle[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(triangle);

      int a = triangle[0] * triangle[0];
      int b = triangle[1] * triangle[1];
      int c = triangle[2] * triangle[2];

      sb.append(a + b == c ? "right\n" : "wrong\n");

    }
    System.out.print(sb);
  }
}
