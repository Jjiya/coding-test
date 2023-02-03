package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_2745 {
  // https://www.acmicpc.net/problem/2745
  //  참고: https://growingarchive.tistory.com/208
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String n = st.nextToken();
    int b = Integer.parseInt(st.nextToken());

    int result = 0;

    for (int i = 0; i < n.length(); i++) {
      result += (getNumericValue(n.charAt(i)) * Math.pow(b, n.length() - i - 1));
    }

    System.out.println(result);
  }

  static int getNumericValue(char numberCode) {
    if ('0' <= numberCode && numberCode <= '9') {
      return numberCode - '0';
    } else {
      return numberCode - 55;
    }
  }
}
