package com.codingTest.baekjoon.silver.bruteForce;

import java.io.*;

public class S_1436 {
  // https://www.acmicpc.net/problem/1436
//    참고: https://cocoon1787.tistory.com/155
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int num = 665;

    while (n > 0) {
      int tmp = ++num;

      while (tmp != 0) {
        if (tmp % 1000 == 666) {
          n--;
          break;
        } else {
          tmp /= 10;
        }
      }
    }

    System.out.print(num);
  }
}
