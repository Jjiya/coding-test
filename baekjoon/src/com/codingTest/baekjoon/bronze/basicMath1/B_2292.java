package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;

public class B_2292 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int passedRoomCount = 1, lastRoomNum = 1;

    while (passedRoomCount <= n) {
      if (n <= lastRoomNum) break;
      lastRoomNum += (passedRoomCount++) * 6;
    }

    System.out.print(passedRoomCount);
  }
}
