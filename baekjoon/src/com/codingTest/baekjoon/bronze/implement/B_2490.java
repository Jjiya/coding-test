package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_2490 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] yutResult = {'E', 'A', 'B', 'C', 'D'};

    for (int i = 0; i < 3; i++) {
      int count = 0;
      for (String yutStatus : br.readLine().split("\\s")) {
        if (yutStatus.equals("0")) {
          count++;
        }
      }
      System.out.println(yutResult[count]);
    }
  }
}
