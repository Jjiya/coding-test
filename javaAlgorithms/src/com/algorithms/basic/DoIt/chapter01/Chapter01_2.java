package com.algorithms.basic.DoIt.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Chapter01_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int value;
    do {
      System.out.print("n값: ");
      value = Integer.parseInt(br.readLine());
    } while (value < 0);

//    studyWhile(value);
//    studyDoWhile(value);

//    testWhile(value);
//    testDoWhile(value);

    example1_12(value);
    example1_13(value);
  }

  static void example1_12(int n) {
    System.out.println("------start example1_12------");

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        System.out.print("+");
      } else {
        System.out.println("-");
      }
    }

    System.out.println("\n------example1_12------");
  }

  static void example1_13(int n) {
    System.out.println("------start example1_13------");

    for (int i = 0; i < n / 2; i++)
      System.out.print("+-");

    boolean isNOddNumber = n % 2 == 1;

    if (isNOddNumber) {
      System.out.println("+");
    }

    System.out.println("\n------example1_13------");
  }

  static void testDoWhile(int value) {
    System.out.println("--do while 시작 (value = " + value + ")--\n");

    do {
      System.out.println("실행되었수");
      value--;
    } while (0 < value);

    System.out.println("\n--종료 (value = " + value + ")--");
  }

  static void testWhile(int value) {
    System.out.println("--while 시작 (value = " + value + ")--\n");

    while (0 < value) {
      System.out.println("실행되었수");
      value--;
    }

    System.out.println("\n--종료 (value = " + value + ")--");
  }

  static void studyDoWhile(int max) {
    int i = 0;
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("== do while 시작 (i = ").append(i).append(")==").append("\n");
//    System.out.println("==do while 시작 (i = " + i + ")==");

    do {
//      System.out.print((i++) + " ");
      stringBuilder.append(i++).append(" ");
    } while (i < max);

//    System.out.println("\n==while 종료 (i = " + i + ")==");
    stringBuilder.append("\n").append("== do while 종료 (i = ").append(i).append(")==");

    System.out.println(stringBuilder);
  }

  static void studyWhile(int max) {
    int i = 0;
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("==while 시작 (i = ").append(i).append(")==").append("\n");
//    System.out.println("==while 시작 (i = " + i + ")==");

    while (i < max) {
//      System.out.print((i++) + " ");
      stringBuilder.append(i++).append(" ");
    }

//    System.out.println("\n==while 종료 (i = " + i + ")==");
    stringBuilder.append("\n").append("==while 종료 (i = ").append(i).append(")==");

    System.out.println(stringBuilder);
  }
}
