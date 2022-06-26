package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_5585 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int change = 1000 - Integer.parseInt(br.readLine());

    int count = 0;
    int[] yenList = {500, 100, 50, 10, 5};

    for (int yen : yenList) {
      int yenCount = change / yen;
      count += yenCount;
      change -= (yenCount * yen);
      if (change < 5) break;
    }

    System.out.print(count + change);
  }
}
