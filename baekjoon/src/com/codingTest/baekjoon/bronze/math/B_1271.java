package com.codingTest.baekjoon.bronze.math;

import java.util.Scanner;

public class B_1271 {
  public void test() {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int m = scanner.nextInt();

    System.out.println(n / m);
    System.out.print(n % m);
  }
}
