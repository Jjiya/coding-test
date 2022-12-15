package com.codingTest.baekjoon.bronze.math;

import java.io.*;

/**
 * 층수  1   2    3   4   5   6     7
 * ------------------------------------
 * 0층   1   2   3   4   5   6     7
 * 1층   1   3   6   10  15  21    28
 * 2층   1   4   10  20  35  56    84
 * 3층   1   5   15  35  70  126   210
 * 4층   1   6   21  56  126 252   462
 **/

public class B_2775 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCaseCount = Integer.valueOf(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < testCaseCount; i++) {
      sb.append(getResidentCount(Integer.valueOf(br.readLine()), Integer.valueOf(br.readLine()))).append("\n");
    }

    System.out.print(sb);
  }

  static int getResidentCount(int floor, int roomNum) {
    // [floor-1][roomNum] + [floor][roomNum-1]
    return (floor == 0 || roomNum <= 1) ? roomNum : getResidentCount(floor, roomNum - 1) + getResidentCount(floor - 1, roomNum);
  }
}
