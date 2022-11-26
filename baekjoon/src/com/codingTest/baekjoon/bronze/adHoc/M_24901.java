package com.codingTest.baekjoon.bronze.adHoc;

import java.util.Scanner;

// M = mystery - 난이도 측정 x
public class M_24901 {
  public void test() {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <= n; i++) {
      sb.append(Integer.toBinaryString(i));
    }

    System.out.print(sb);
  }
}

/* 답은 아래와 같은데... 제출 안하는게 나을 것 같네 ㅎㅎㅎ
https://karma2.tistory.com/5
 */