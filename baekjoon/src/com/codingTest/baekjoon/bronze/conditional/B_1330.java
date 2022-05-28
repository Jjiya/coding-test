package com.codingTest.baekjoon.bronze.conditional;

import java.io.*;

public class B_1330 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().trim().split("\\s");

    int result = Integer.parseInt(input[0]) - Integer.parseInt(input[1]);

    if (0 < result) System.out.print(">");
    else if (result < 0) System.out.print("<");
    else System.out.print("==");
  }
}
