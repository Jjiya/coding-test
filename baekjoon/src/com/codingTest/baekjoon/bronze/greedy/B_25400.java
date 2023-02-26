package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_25400 {
  // https://www.acmicpc.net/problem/25400
  public static void test() throws IOException {
    M3.test();
  }

  static class M3 {
    // 41_032 KB / 304 ms
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[] cardList = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        cardList[i] = Integer.parseInt(st.nextToken());
      }

      int count = 0;

      for (int i = 0; i < n; i++) {
        if (cardList[i] != i - count + 1) {
          count++;
        }
      }

      System.out.print(count);
    }
  }

  static class M2 {
    // 45_380 KB / 332 ms
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      ArrayList<Integer> cardList = new ArrayList<>(n);

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        cardList.add(Integer.parseInt(st.nextToken()));
      }

      int count = 0;

      for (int i = 0; i < cardList.size(); i++) {
        if (cardList.get(i) != i - count + 1) {
          count++;
        }
      }

      System.out.print(count);
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      ArrayList<Integer> cardList = new ArrayList<>(n);

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        cardList.add(Integer.parseInt(st.nextToken()));
      }

      int count = 0;

      for (int i = 0; i < cardList.size(); i++) {
        if (cardList.get(i) != i + 1) {
          cardList.remove(i);
          count++;
          i--;
        }
      }

      System.out.print(count);
    }
  }
}
