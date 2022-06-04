package com.codingTest.baekjoon.bronze.conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9498 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine().trim());
    char score;

    switch (input / 10) {
      case 10:
      case 9:
        score = 'A';
        break;
      case 8:
        score = 'B';
        break;
      case 7:
        score = 'C';
        break;
      case 6:
        score = 'D';
        break;
      default:
        score = 'F';
    }
    System.out.println(score);
  }
}
