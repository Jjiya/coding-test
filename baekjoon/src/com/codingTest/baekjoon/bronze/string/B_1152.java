package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_1152 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    System.out.print(st.countTokens());
  }

  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer inputs = new StringTokenizer(br.readLine());

    int count = 0;
    while (inputs.hasMoreTokens()) {
      if (!inputs.nextToken().trim().equals("")) count++;
    }
    System.out.print(count);
  }
}
