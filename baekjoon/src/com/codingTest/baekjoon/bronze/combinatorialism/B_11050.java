package com.codingTest.baekjoon.bronze.combinatorialism;

import java.io.*;
import java.util.StringTokenizer;

public class B_11050 {
  static int[] factorial = new int[11];

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    System.out.print((int) (getFactorial(n) / (double) (getFactorial(k) * getFactorial(n - k))));
  }

  static int getFactorial(int num) {
    if (num <= 1) {
      return 1;
    }

    if (factorial[num] != 0) return factorial[num];

    return factorial[num] = num * getFactorial(num - 1);
  }
}
