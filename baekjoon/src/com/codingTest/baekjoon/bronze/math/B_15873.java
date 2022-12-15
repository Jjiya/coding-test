package com.codingTest.baekjoon.bronze.math;

import java.io.*;

public class B_15873 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int a, b;
    String input = br.readLine();

    if (input.length() == 4) {
      a = Integer.parseInt(input.substring(0, 2));
      b = Integer.parseInt(input.substring(2, 4));
    } else if (input.length() == 2) {
      a = input.charAt(0) - 48;
      b = input.charAt(1) - 48;
    } else {
      int zeroIndex = input.indexOf("0");

      if (zeroIndex == 1) {
        a = Integer.parseInt(input.substring(0, 2));
        b = input.charAt(2) - 48;
      } else {
        a = input.charAt(0) - 48;
        b = Integer.parseInt(input.substring(1, 3));
      }
    }

    System.out.print(a + b);
  }
}
