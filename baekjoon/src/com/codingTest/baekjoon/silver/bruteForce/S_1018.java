package com.codingTest.baekjoon.silver.bruteForce;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class S_1018 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int height = Integer.parseInt(st.nextToken()), width = Integer.parseInt(st.nextToken());

    String[][] chess = new String[height][width];

    for (int i = 0; i < height; i++) {
      chess[i] = Arrays.copyOf(br.readLine().split(""), width);
    }
    System.out.println("---");
//    int minimum = Integer.MAX_VALUE;
    for (int i = 0; i <= height - 8; i++) {
      for (int h = 0; h < 8; h++) {
        System.out.print(" ".repeat(h - i));
        for (int j = 0; j < width; j++) {
          System.out.print(chess[i][j]);
        }
        System.out.println();
      }
      System.out.println("---");
    }

  }

  static Predicate<String> isB = "B"::equals;
}
