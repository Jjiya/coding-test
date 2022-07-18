package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_9095 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int[] count = new int[12];
    count[1] = 1;
    count[2] = 2;
    count[3] = 4;

    for (int i = 4; i < count.length; i++) {
      int sum = count[i - 1] + count[i - 2] + count[i - 3];
      count[i] = sum;
    }
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(count[n]).append("\n");
    }

    System.out.print(sb);
  }

  /*
  [1] - 1

  1
  -------------
  [2] - 2
  1 1
  -------------
  2
  -------------
  [3] - 4

  1 1 1
  -------------
  1 2
  2 1
  -------------
  3
  -------------
  [4] - 7

  1 1 1 1
  -------------
  1 1 2
  1 2 1
  2 1 1
  2 2
  -------------
  3 1
  1 3
  -------------
  [5] - 13
  1 1 1 1 1
  -------------
  1 1 1 2
  1 1 2 1
  1 2 1 1
  2 1 1 1
  2 2 1
  2 1 2
  1 2 2
  -------------
  1 1 3
  1 3 1
  3 1 1
  3 2
  2 3
  -------------
  */


//  11111
//
//  111 2
//  11 2 1
//  1 2 11
//  2 111
//
//  11 3
//  3 11
//  2 3
//  3 2


}
