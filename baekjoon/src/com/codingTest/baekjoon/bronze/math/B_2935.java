package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.math.BigInteger;

public class B_2935 {
  // https://www.acmicpc.net/problem/2935
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BigInteger a = new BigInteger(br.readLine());
    String operator = br.readLine();
    BigInteger b = new BigInteger(br.readLine());

    System.out.print(operator.equals("+") ? a.add(b) : a.multiply(b));
  }
}