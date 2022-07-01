package com.codingTest.baekjoon.silver.sorting;

import java.io.*;

public class S_2751 {
  int[] sorted;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] array = new int[n];
    sorted = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }

    merge(array, 0, n - 1);

    StringBuilder sb = new StringBuilder(n * 2);
    for (int i = 0; i < n; i++) {
      sb.append(array[i]).append("\n");
    }
    System.out.print(sb);
  }

  void merge(int[] array, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;
      merge(array, start, middle);
      merge(array, middle + 1, end);

      mergeSort(array, start, middle, end);
    }
  }

  void mergeSort(int[] array, int start, int end) {
    int middle = (start + end) / 2;

    int left = start, right = middle + 1, index = start;

    while (left <= middle && right <= end) {
      if (array[left] > array[right]) {
        sorted[index++] = array[right++];
      } else {
        sorted[index++] = array[left++];
      }
    }
    if (left < middle) {
      for (int i = left; i <= middle; i++) {
        sorted[index++] = array[i];
      }
    } else {
      for (int i = right; i < end; i++) {
        sorted[index++] = array[i];
      }
    }
    for (int i = start; i < end; i++) {
      array[i] = sorted[i];
    }
  }

  void mergeSort(int[] array, int start, int middle, int end) {
    int left = start, right = middle + 1, index = start;

    while (left <= middle && right <= end) {
      if (array[left] <= array[right]) {
        sorted[index++] = array[left++];
      } else {
        sorted[index++] = array[right++];
      }
    }

    if (left > middle) {
      for (int i = right; i <= end; i++) {
        sorted[index++] = array[i];
      }
    } else {
      for (int i = left; i <= middle; i++) {
        sorted[index++] = array[i];
      }
    }

    for (int t = start; t <= end; t++) {
      array[t] = sorted[t];
    }
  }
}

