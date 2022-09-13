package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_10987 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = 0;
    for (char character : br.readLine().toCharArray()) {
      if ("aeiou".indexOf(character) != -1) count++;
    }

    System.out.print(count);
  }
}
