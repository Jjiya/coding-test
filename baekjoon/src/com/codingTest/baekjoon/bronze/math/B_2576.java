package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_2576 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sum = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < 7; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num % 2 == 1) {
        sum += num;
        min = Math.min(min, num);
      }
    }

    if (sum == 0) {
      System.out.print(-1);
    } else {
      System.out.println(sum);
      System.out.print(min);
    }
  }
}
