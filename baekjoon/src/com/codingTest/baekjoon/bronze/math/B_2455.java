package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_2455 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int currentCount = 0;
    int maxCount = 0;

    for (int i = 0; i < 4; i++) {
      st = new StringTokenizer(br.readLine());
      int outCount = Integer.parseInt(st.nextToken());
      int inCount = Integer.parseInt(st.nextToken());

      maxCount = Math.max(maxCount, (currentCount + inCount - outCount));
      currentCount += inCount - outCount;
    }

    System.out.print(maxCount);
  }
}
