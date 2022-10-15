package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_1550 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    int convertNum = 0;
    for (int i = 0; i < input.length(); i++) {
      int num = input.charAt(i);
      if (65 <= num) {
        num -= 55;
      } else {
        num -= 48;
      }
      int digitIdx = input.length() - i - 1;
      convertNum += (num * Math.pow(16, digitIdx));
    }

    System.out.print(convertNum);
  }
}
