package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_5622 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] inputs = br.readLine().toCharArray();
    int sum = 0;
    for (int i = 0; i < inputs.length; i++) {
      sum += getTime(inputs[i]);
    }

    System.out.print(sum);
  }

  static int getTime(char alphabet) {
    if (alphabet < 'D') {
      return 3;
    } else if (alphabet < 'G') {
      return 4;
    } else if (alphabet < 'J') {
      return 5;
    } else if (alphabet < 'M') {
      return 6;
    } else if (alphabet < 'P') {
      return 7;
    } else if (alphabet < 'T') {
      return 8;
    } else if (alphabet < 'W') {
      return 9;
    } else if ('W' <= alphabet) {
      return 10;
    }
    return 0;
  }
}
