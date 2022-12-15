package com.codingTest.baekjoon.bronze.math;

import java.util.Scanner;

public class B_15964 {
  public void test() {
    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.print((a + b) * (a - b));
  }
}
