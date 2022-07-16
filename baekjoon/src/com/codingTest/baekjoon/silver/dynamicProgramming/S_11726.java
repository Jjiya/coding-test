package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_11726 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] count = new int[n + 1];
    count[0] = -1;
    count[1] = 1;

    for (int i = 2; i <= n; i++) {
      if (i == 2) {
        count[i] = 2;
      } else {
        count[i] = (count[i - 1] + count[i - 2]) % 10007;
      }
    }

    System.out.print(count[n]);
  }

  //  시간 초과
  int getTileCount(int width) {
    if (width <= 2) {
      return width;
    } else {
      return (getTileCount(width - 1) + getTileCount(width - 2)) % 10007;
    }
  }
}
