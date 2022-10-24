package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_10988 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();

    int endIdx = word.length() - 1;
    for (int i = 0; i < word.length() / 2; i++) {
      if (word.charAt(i) != word.charAt(endIdx)) {
        System.out.print(0);
        return;
      }
      endIdx--;
    }

    System.out.print(1);
  }
}
