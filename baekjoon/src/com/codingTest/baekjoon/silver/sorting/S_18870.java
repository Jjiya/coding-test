package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.*;

public class S_18870 {
  // https://www.acmicpc.net/problem/18870
  static HashMap<Integer, Integer> compressionList;
  static Integer[] sort;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] x = new int[n];
    HashSet<Integer> xList = new HashSet<>();
    compressionList = new HashMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      x[i] = Integer.parseInt(st.nextToken());
      xList.add(x[i]);
    }

    sort = xList.toArray(new Integer[0]);
    Arrays.sort(sort);

    StringBuilder sb = new StringBuilder();

    for (int xi : x) {
      int result;

      if (compressionList.containsKey(xi)) {
        result = compressionList.get(xi);
      } else {
        result = binarySearch(xi);
        compressionList.put(xi, result);
      }

      sb.append(result).append(" ");
    }

    System.out.println(sb);
  }

  static class M1 {
    //    시간 초과 이유: https://www.acmicpc.net/board/view/76851
//    List에서 특정 요소의 위치를 모를 때 요소를 찾는 연산은 O(N)
//    for문에서 list.contains를 쓰면 O(N^2)과 동일하다고 함
    static ArrayList<Integer> sort;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[] x = new int[n];
      sort = new ArrayList<>(n);
      compressionList = new HashMap<>();

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        x[i] = Integer.parseInt(st.nextToken());

        if (!sort.contains(x[i])) {
          sort.add(x[i]);
        }
      }

      Collections.sort(sort);

      StringBuilder sb = new StringBuilder();

      for (int xi : x) {
        int result;

        if (compressionList.containsKey(xi)) {
          result = compressionList.get(xi);
        } else {
          result = binarySearch(xi);
          compressionList.put(xi, result);
        }

        sb.append(result).append(" ");
      }

      System.out.println(sb);
    }
  }

  static int binarySearch(int findNumber) {
    if (sort.length == 1) {
      return 0;
    }

    int start = 0;
    int end = sort.length;
    int mid = (start + end) / 2;

    while (start < end) {
      int peek = sort[mid];

      if (peek == findNumber) {
        return mid;
      }

      if (peek < findNumber) {
        start = mid + 1;
      } else {
        end = mid;
      }

      mid = (start + end) / 2;
    }

    return mid;
  }
}
