package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_10821 {
  // https://www.acmicpc.net/problem/10821
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), ",");

    System.out.println(st.countTokens());
  }
}
