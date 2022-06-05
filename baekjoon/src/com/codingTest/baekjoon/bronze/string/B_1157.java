package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.*;

public class B_1157 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = (br.readLine().toUpperCase(Locale.ROOT)).toCharArray();

    int[] count = new int[26];

    for (char alphabet : input) {
      ++count[alphabet - 65];
    }

    int max = -1, maxIdx = -1, subMax = -1;

    for (int i = 0; i < count.length; i++) {
      if (max < count[i]) {
        max = count[i];
        maxIdx = i;
      } else if (max == count[i]) {
        subMax = count[i];
      }
    }

    System.out.print(max == subMax ? "?" : Character.toString(maxIdx + 65));
  }
}
