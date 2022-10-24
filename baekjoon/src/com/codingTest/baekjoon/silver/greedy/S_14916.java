package com.codingTest.baekjoon.silver.greedy;

import java.util.Scanner;

public class S_14916 {
  public void test() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    if (n == 2) {
      System.out.print(1);
    } else if (n % 5 == 0) {
      System.out.print(n / 5);
    } else {
      int count = 0;
//       while 내의 순서가 헷갈림... 5를 빼는게 우선인 줄 알고 n-=2 를 계속 안해줬었다... 5를 빼거나 나눴을 때 2로 안나눠진 경우에 또 2를 나누고...악순환
      while (1 < n) {
        if (n % 5 == 0) {
          count += n / 5;
          n %= 5;
        } else {
          n -= 2;
          count++;
        }
      }

      System.out.print(n == 0 ? count : -1);
    }
  }
}