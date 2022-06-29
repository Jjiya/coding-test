package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class B_2750 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(i, Integer.parseInt(br.readLine()));
    }
    StringBuilder sb = new StringBuilder();
    list.sort(Integer::compareTo);
    list.forEach(num -> sb.append(num).append("\n"));
    System.out.print(sb);
  }

  public static void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] list = new int[n];
    Arrays.fill(list, 0);
    for (int i = 0; i < list.length; i++) {
      int value = Integer.parseInt(br.readLine());
      for (int j = i + 1; j < list.length; j++) {

      }
    }
  }
}
