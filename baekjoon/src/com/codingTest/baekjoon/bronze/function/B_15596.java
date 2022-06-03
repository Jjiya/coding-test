package com.codingTest.baekjoon.bronze.function;

public class B_15596 {
  public static void test() {
    int[] a = {1, 2, 4, 5};
    System.out.println(sum(a));
  }

  static long sum(int[] a) {
    long sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }

    return sum;
  }
}
