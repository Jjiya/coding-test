package com.codingTest.baekjoon.bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10808 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    int[] alphabetCount = new int[26];

    for (int i = 0; i < word.length(); i++) {
      alphabetCount[word.charAt(i) - 97]++;
    }

    StringBuilder sb = new StringBuilder();
    for (int count : alphabetCount) {
      sb.append(count).append(" ");
    }

    System.out.print(sb);
  }
}
