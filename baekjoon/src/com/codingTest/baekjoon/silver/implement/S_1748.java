package com.codingTest.baekjoon.silver.implement;

import java.io.*;

public class S_1748 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    System.out.print(getLength(n));
  }

  static int getLength(int num) {
    int length = (num + "").length();

    if (length == 1) {
      return num;
    }

    int digitValue = (int) Math.pow(10, length - 1) - 1;

    return getLength(digitValue) + (num - digitValue) * length;
  }
  /*
  
  (digit-1)의 마지막 자리 길이 + (현재 숫자 - (digit-1)길이를 가진 최대 값) * 현재 숫자의 자리 수

  - 1번째
  0 + (1 - 0) * 1

  - 2번째
  0 + (2 - 0) * 1

  - 10번째
  9 + (10 - 9) * 2
  9 + 2 = 11

  - 11번째
  9 + (11 - 9) * 2
  9 + 4 = 13

  - 12번째
  9 + (12 - 9) * 2
  9 + 6 = 15

  - 99번째
  9 + (99 - 9) * 2
  9 + 180 = 189

  - 100번째
  189 + (100 - 99) * 3
  189 + 3

  - 105번째
  189 + (105 - 99) * 3
  189 + 18 = 207

  - 120번째
  189 + (120 - 99) * 3
  189 + 63 = 252
   */
}
