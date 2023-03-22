package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_27866 {
  // https://www.acmicpc.net/problem/27866
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(br.readLine().charAt(Integer.parseInt(br.readLine()) - 1));
  }
}
