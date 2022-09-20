package com.codingTest.baekjoon.silver.string;

import java.io.*;

public class S_1439 {
  static int zeroCount = 0, oneCount = 0;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    increaseCount(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char currentNum = s.charAt(i);
      if (s.charAt(i - 1) != currentNum) {
        increaseCount(currentNum);
      }
    }

    System.out.print(Math.min(zeroCount, oneCount));
  }

  static void increaseCount(char numValue) {
    if (numValue == '1') {
      oneCount++;
    } else {
      zeroCount++;
    }
  }
}
