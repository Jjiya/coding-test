package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_2566 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int max = -1;
    int[] maxPosition = new int[2];
    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (max < num) {
          max = num;
          maxPosition[0] = i;
          maxPosition[1] = j;
        }
      }
    }

    System.out.println(max);
    System.out.print((maxPosition[0] + 1) + " " + (maxPosition[1] + 1));
  }
}
