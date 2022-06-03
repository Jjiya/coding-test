package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;

public class B_2562 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int idx = 1, max = 0, maxIdx = 0;

    String tmp = "";

    while ((tmp = br.readLine()) != null) {
      int num = Integer.parseInt(tmp);
      if (max < num) {
        max = num;
        maxIdx = idx;
      }
      idx++;
    }
    System.out.println(max);
    System.out.print(maxIdx);
  }
}
