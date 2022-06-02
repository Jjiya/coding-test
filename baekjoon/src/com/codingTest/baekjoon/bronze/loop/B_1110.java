package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_1110 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine().trim());
    int newN = n;
    int count = 0;

    while (true) {
      int a, b;

      a = newN % 10;  // 2번째 자리의 숫자 구하기
      b = ((newN / 10) + a) % 10; // (1번째 자리의 숫자 + 2번째 자리의 숫자) 연산한 뒤 2번째 자리 수 구하기

      newN = (a * 10) + b;  // 기존 2번째 자리 수 + 새로 구한 숫자의 2번째 자리 수

      count++;
      if (n == newN) break;
    }

    System.out.print(count);
  }
}
