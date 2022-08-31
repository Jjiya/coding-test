package com.codingTest.baekjoon.silver.sorting;

import java.io.*;

public class S_1427 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] numCount = new int[10];

    for (char number : br.readLine().toCharArray()) {
      numCount[number - 48]++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 9; i >= 0; i--) {
      for (int j = 0; j < numCount[i]; j++) {
        sb.append(i);
      }
    }
    System.out.println(sb);
  }
}
