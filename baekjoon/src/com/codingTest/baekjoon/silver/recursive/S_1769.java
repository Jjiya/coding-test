package com.codingTest.baekjoon.silver.recursive;

import java.io.*;

public class S_1769 {
  static int count = 0;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sum = sumDigit(br.readLine());

    System.out.println(count);
    System.out.print(sum % 3 == 0 ? "YES" : "NO");
  }

  static int sumDigit(String number) {
    if (number.length() < 2) {
      return Integer.parseInt(number);
    }

    count++;

    int sum = 0;
    for (char n : number.toCharArray()) {
      sum += n - 48;
    }

    return sumDigit(String.valueOf(sum));
  }

  static int sumDigit(int number) {
    if (number < 10) {
      return number;
    }

    count++;

    int sum = 0;

    while (number > 0) {
      sum += number % 10;
      number /= 10;
    }

    return sumDigit(sum);
  }
}
