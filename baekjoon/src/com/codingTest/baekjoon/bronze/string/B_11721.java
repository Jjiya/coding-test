package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_11721 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputs = br.readLine();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < inputs.length(); i += 10) {
      sb.append(inputs, i, Math.min(i + 10, inputs.length())).append("\n");
    }

    System.out.print(sb);
  }
}
