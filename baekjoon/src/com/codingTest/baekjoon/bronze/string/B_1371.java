package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_1371 {
  // https://www.acmicpc.net/problem/1371
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    int[] count = new int[26];
    int max = 0;

    while ((input = br.readLine()) != null) {
      for (char letter : input.toCharArray()) {
        if (letter == ' ') {
          continue;
        }

        count[letter - 97]++;
        max = Math.max(max, count[letter - 97]);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 26; i++) {
      if (count[i] == max) {
        sb.append((char) (i + 97));
      }
    }

    System.out.print(sb);
  }
}
