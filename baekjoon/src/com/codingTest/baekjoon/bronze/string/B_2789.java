package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_2789 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print(br.readLine().replaceAll("[CAMBRIDGE]", ""));
  }
}
