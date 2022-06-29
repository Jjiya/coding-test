package com.codingTest.baekjoon.silver.string;

import java.io.*;

public class S_2941 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    String[] patterns = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    for (int i = 0; i < patterns.length; i++) {
      input = input.replace(patterns[i], "*");
    }

    System.out.print(input.length());
  }
}
