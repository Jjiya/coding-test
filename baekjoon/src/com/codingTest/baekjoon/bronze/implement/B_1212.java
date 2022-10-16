package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_1212 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String octalNumber = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < octalNumber.length(); i++) {
      String binaryNumber = convertBinaryNumber(octalNumber.charAt(i) - 48);

      if (i == 0) {
        binaryNumber = String.valueOf(Integer.parseInt(binaryNumber));
      }
      sb.append(binaryNumber);
    }

    System.out.print(sb);
  }

  static String convertBinaryNumber(int octalNumber) {
    StringBuilder binaryNumber = new StringBuilder();

    while (0 < octalNumber) {
      binaryNumber.append(octalNumber % 2);
      octalNumber /= 2;
    }
    if (binaryNumber.length() < 3) {
      int currentLength = binaryNumber.length();
      for (int i = 0; i < 3 - currentLength; i++) {
        binaryNumber.append("0");
      }
    }

    return binaryNumber.reverse().toString();
  }
}
