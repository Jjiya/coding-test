package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.Arrays;

public class B_10162 {
  public void test() throws IOException {
    int a = (5 * 60), b = 60, c = 10;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int time = Integer.parseInt(br.readLine());

    if (time % 10 != 0) {
      System.out.print(-1);
      return;
    }

    if (time % a == 0) {
      System.out.print((time / a) + " 0 0");
      return;
    }

    int[] count = new int[3];
    Arrays.fill(count, 0);

    while (0 < time) {
      if (a <= time && (time - a) % c == 0) {
        count[0] += 1;
        time -= a;
      } else if (b <= time && (time - b) % c == 0) {
        count[1] += 1;
        time -= b;
      } else if (c <= time && time % c == 0) {
        count[2] += time / c;
        time = 0;
      } else {
        System.out.print(-1);
        return;
      }
    }

    System.out.printf("%d %d %d", count[0], count[1], count[2]);
  }
}
