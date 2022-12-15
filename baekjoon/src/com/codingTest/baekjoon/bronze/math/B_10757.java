package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_10757 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    System.out.print(new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken())));
  }
}