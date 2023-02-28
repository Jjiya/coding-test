package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class S_15904 {
  // https://www.acmicpc.net/problem/15904
  public static void test() throws IOException {
    M3.test();
  }

  static class M3 {
    //    11452kb	80ms
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String UCPC = "UCPC";
      int lowerIdx = 0;

      for (char current : br.readLine().toCharArray()) {
        if (current == UCPC.charAt(lowerIdx)) {
          lowerIdx++;
        }

        if (lowerIdx == UCPC.length()) {
          System.out.print("I love UCPC");
          return;
        }
      }

      System.out.print("I hate UCPC");
    }
  }

  static class M2 {
    //    11524kb	80ms
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      String UCPC = "UCPC";
      int lowerIdx = 0;

      while (st.hasMoreTokens()) {
        String word = st.nextToken();

        for (int i = 0; i < word.length(); i++) {
          char current = word.charAt(i);

          if (current == UCPC.charAt(lowerIdx)) {
            lowerIdx++;
          }

          if (lowerIdx == UCPC.length()) {
            System.out.print("I love UCPC");
            return;
          }
        }
      }

      System.out.print("I hate UCPC");
    }
  }

  static class M1 {
    //    11504kb	76ms
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      String UCPC = "UCPC";

      int lowerIdx = 0;
      int upperIdx = 0;

      while (st.hasMoreTokens()) {
        String word = st.nextToken();

        for (int i = 0; i < word.length(); i++) {
          char current = word.charAt(i);

          if ('a' <= current && current <= 'z') {
            if (current == UCPC.toLowerCase(Locale.ROOT).charAt(lowerIdx)) {
              lowerIdx++;
            }
          } else if (current == UCPC.charAt(upperIdx)) {
            upperIdx++;
          }

          if (lowerIdx == UCPC.length() || upperIdx == UCPC.length()) {
            System.out.print("I love UCPC");
            return;
          }
        }
      }

      System.out.print("I hate UCPC");
    }
  }
}
/* 반례
UCPCC
=> I love UCPC
*/