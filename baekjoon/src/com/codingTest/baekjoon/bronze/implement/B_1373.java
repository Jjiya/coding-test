package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_1373 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder binaryNumber = new StringBuilder(br.readLine());

    int split3Word = binaryNumber.length() % 3;
    if (split3Word != 0) {
      for (int i = 0; i < 3 - split3Word; i++) {
        binaryNumber.insert(0, "0");
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < binaryNumber.length(); i += 3) {
      sb.append(
          (binaryNumber.charAt(i) - 48) * 4
              + (binaryNumber.charAt(i + 1) - 48) * 2
              + (binaryNumber.charAt(i + 2) - 48)
      );
    }

    System.out.print(sb);
  }
}
