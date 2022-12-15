package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_10824 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    long d = Long.parseLong(st.nextToken());

    long ab = (long) (a * (Math.pow(10, (b + "").length()))) + b;
    long cd = (long) (c * (Math.pow(10, (d + "").length()))) + d;

    System.out.print(ab + cd);
  }

  //  사람들은 그냥 문자열을 합치넹...
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String ab = st.nextToken() + st.nextToken();
    String cd = st.nextToken() + st.nextToken();

    System.out.print(Long.parseLong(ab) + Long.parseLong(cd));
  }
}
