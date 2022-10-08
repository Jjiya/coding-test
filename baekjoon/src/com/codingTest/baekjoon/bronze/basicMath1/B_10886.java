package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;

public class B_10886 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += Integer.parseInt(br.readLine());
    }

    System.out.print((int) Math.ceil(n / 2.0) > sum ? "Junhee is not cute!" : "Junhee is cute!");
  }
}
