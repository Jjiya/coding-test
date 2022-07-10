package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2558 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());

    System.out.print(a + b);
  }
}
