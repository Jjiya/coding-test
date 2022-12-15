package com.codingTest.baekjoon.silver.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class S_14490 {
  // https://www.acmicpc.net/problem/14490
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), ":");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int gcdNum = gcd(n, m);

    System.out.printf("%d:%d", n / gcdNum, m / gcdNum);
  }

  static int gcd(int n, int m) {
    if (n % m == 0) {
      return m;
    }

    return gcd(m, n % m);
  }
}
