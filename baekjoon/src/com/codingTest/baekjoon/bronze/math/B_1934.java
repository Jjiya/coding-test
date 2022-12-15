package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_1934 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(lcm(a, b)).append("\n");
    }

    System.out.print(sb);
  }

  //  최대 공배수
  static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  //  최대 공약수
  static int gcd(int a, int b) {
    int r;
    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }

    return a;
  }
}
