package com.codingTest.baekjoon.bronze.basicMath1;

import java.util.Scanner;

public class B_2420 {
  public void test() {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextInt();
    long m = scanner.nextInt();

    System.out.print(Math.abs(n - m));
  }
}
