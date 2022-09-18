package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_1259 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringBuilder sb = new StringBuilder();

    while (!(input = br.readLine()).equals("0")) {
      int num = Integer.parseInt(input);
      int revers = 0;

      for (int i = 0; i < input.length() / 2; i++) {
        revers = (revers * (int) Math.pow(10, i)) + (num % 10);
        num /= 10;
      }

      if (input.length() % 2 == 1) {
        num /= 10;
      }

      sb.append(revers == num ? "yes" : "no").append("\n");
    }

    System.out.print(sb);
  }
}
