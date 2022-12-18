package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_13410 {
  // https://www.acmicpc.net/problem/13410
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] multiplicationTable = new int[k];

    for (int i = 1; i <= k; i++) {
      int multiple = n * i;

      int subResult = 0;

      while (0 < multiple) {
        subResult = (subResult * 10) + multiple % 10;
        multiple /= 10;
      }

      multiplicationTable[i - 1] = subResult;
    }

    Arrays.sort(multiplicationTable);

    System.out.println(multiplicationTable[k - 1]);
  }
}
