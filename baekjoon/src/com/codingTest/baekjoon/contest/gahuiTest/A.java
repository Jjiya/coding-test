package com.codingTest.baekjoon.contest.gahuiTest;

import java.io.*;
import java.util.StringTokenizer;

public class A {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    double a = Integer.parseInt(st.nextToken());
    double b = Double.parseDouble(st.nextToken());

    double earnedRunAverage = a - (a * (1.0 - (b / 100)));

    System.out.print(100 <= a - earnedRunAverage ? 0 : 1);
  }
}
