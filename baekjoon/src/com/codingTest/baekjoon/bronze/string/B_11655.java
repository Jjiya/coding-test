package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_11655 {
  // https://www.acmicpc.net/problem/11655
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    for (char alphabet : br.readLine().toCharArray()) {
      if (alphabet == ' ' || ('0' <= alphabet && alphabet <= '9')) {
        sb.append(alphabet);
        continue;
      }

      char ROT13 = (char) (alphabet + 13);

      if (('Z' < ROT13 && alphabet <= 'Z') || 'z' < ROT13) {
        ROT13 -= 26;
      }

      sb.append(ROT13);
    }
    sb.append(" ");


    System.out.print(sb);
  }
}
