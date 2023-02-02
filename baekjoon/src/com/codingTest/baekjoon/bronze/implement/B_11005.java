package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_11005 {
  // https://www.acmicpc.net/problem/11005
  /*
  숫자 n을 b진법으로 변환하는 방법은
  n을 b로 더 이상 나누어지지 않을 때까지 나눈 후
  나머지부터 나눈 값을 뒤에서부터 합치면 됨
   */
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();

    while (0 < n) {
      sb.append(convertAlphabet(n % b));
      n /= b;
    }

    System.out.println(sb.reverse());
  }

  static String convertAlphabet(int remain) {
    if (remain < 10) {
      return remain + "";
    } else {
      return String.valueOf((char) (remain + 55));
    }
  }
}
/* 반례
1 2
=> 1

 */
