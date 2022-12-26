package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;
import java.util.Arrays;

public class B_2587 {
  // https://www.acmicpc.net/problem/2587
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] numeric = new int[5];
    int sum = 0;

    for (int i = 0; i < 5; i++) {
      numeric[i] = Integer.parseInt(br.readLine());
      sum += numeric[i];
    }

    Arrays.sort(numeric);

    System.out.println(sum/5);
    System.out.print(numeric[2]);
  }
}
