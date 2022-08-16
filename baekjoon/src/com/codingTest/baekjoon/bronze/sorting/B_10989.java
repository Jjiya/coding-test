package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;

public class B_10989 {
  int[] sorted;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] count = new int[10001];

    for (int j = 0; j < n; j++) {
      count[arr[j]]++;
    }

    for (int k = 1; k < count.length; k++) {
      count[k] += count[k - 1];
    }

    int[] result = new int[n];

    for (int l = arr.length - 1; l >= 0; l--) {
      int number = arr[l];
      count[number]--;
      result[count[number]] = number;
    }

    StringBuilder sb = new StringBuilder();
    for (int number : result) {
      sb.append(number).append("\n");
    }

    System.out.print(sb);
  }


  public void test1() throws IOException {
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
