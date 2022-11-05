package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_3447 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    StringBuilder sb = new StringBuilder();

    while ((input = br.readLine()) != null) {
      while (input.contains("BUG")) {
        input = input.replace("BUG", "");
      }

      sb.append(input).append("\n");
    }

    System.out.print(sb);
  }
}
