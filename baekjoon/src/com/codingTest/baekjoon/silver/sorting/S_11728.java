package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_11728 {
  static int[] sorted;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());


    int aSize = Integer.parseInt(st.nextToken());
    int bSize = Integer.parseInt(st.nextToken());

    int[] ab = new int[aSize + bSize];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < aSize; i++) {
      ab[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = aSize; i < aSize + bSize; i++) {
      ab[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    Arrays.sort(ab);
    Arrays.stream(ab).forEach(result -> sb.append(result).append(" "));

    System.out.print(sb);
  }

  public void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int aSize = Integer.parseInt(st.nextToken());
    int bSize = Integer.parseInt(st.nextToken());

    sorted = new int[aSize + bSize];
    int[] a = new int[aSize + bSize];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < aSize; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = aSize; i < aSize + bSize; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(a, 0, a.length - 1);

    StringBuilder sb = new StringBuilder();
    Arrays.stream(sorted).forEach(result -> sb.append(result).append(" "));

    System.out.print(sb);
  }

  static void mergeSort(int[] a, int left, int right) {
    if (left == right) return;
    int mid = (left + right) / 2;

    mergeSort(a, left, mid);
    mergeSort(a, mid + 1, right);

    merge(a, left, mid, right);
  }

  static void merge(int[] a, int left, int mid, int right) {
    int subLeft = left;
    int subRight = mid + 1;
    int idx = left;

    while (subLeft <= mid && subRight <= right) {
      if (a[subLeft] <= a[subRight]) {
        sorted[idx] = a[subLeft];
        subLeft++;
      } else {
        sorted[idx] = a[subRight];
        subRight++;
      }
      idx++;

      if (subLeft > mid) {
        while (subRight <= right) {
          sorted[idx] = a[subRight];
          idx++;
          subRight++;
        }
      } else {
        while (subLeft <= mid) {
          sorted[idx] = a[subLeft];
          idx++;
          subLeft++;
        }
      }
    }

    for (int i = left; i <= right; i++) {
      a[i] = sorted[i];
    }
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashSet<Integer> ab = new HashSet<>();

    int aSize = Integer.parseInt(st.nextToken());
    int bSize = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < aSize; i++) {
      ab.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < bSize; i++) {
      ab.add(Integer.parseInt(st.nextToken()));
    }

    StringBuilder sb = new StringBuilder();
    ab.stream().sorted().forEach(result -> sb.append(result).append(" "));

    System.out.print(sb);
  }
}
