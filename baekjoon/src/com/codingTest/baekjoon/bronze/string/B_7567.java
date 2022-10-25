package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_7567 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String bowl = br.readLine();

    int height = 10;
    for (int i = 1; i < bowl.length(); i++) {
      if (bowl.charAt(i) == bowl.charAt(i - 1)) {
        height += 5;
      } else {
        height += 10;
      }
    }

    System.out.print(height);
  }
}