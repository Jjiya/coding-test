package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;

public class B_10989 {
  int[] sorted;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] array = new int[n];
    sorted = new int[n];

    while (--n >= 0) {
      array[n] = Integer.parseInt(br.readLine());
    }

    merge(array, 0, array.length - 1);

    StringBuilder sb = new StringBuilder();
    n = 0;

    while (n < array.length) {
      sb.append(array[n++]).append("\n");
    }

    System.out.print(sb);
  }

  void merge(int[] array, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;
      merge(array, start, middle);
      merge(array, middle + 1, end);
      sort(array, start, middle, end);

      while (start <= end) {
        array[start] = sorted[start];
        start++;
      }
    }
  }

  void sort(int[] array, int start, int middle, int end) {
    int i = start, j = middle + 1, idx = start;
    while (i <= middle && j <= end) {
      if (array[i] > array[j]) {
        sorted[idx++] = array[j++];
      } else {
        sorted[idx++] = array[i++];
      }
    }

    if (i > middle) {
      while (j <= end) {
        sorted[idx++] = array[j++];
      }
    } else {
      while (i <= middle) {
        sorted[idx++] = array[i++];
      }
    }
  }
}
