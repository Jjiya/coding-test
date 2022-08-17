package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class S_1181 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashSet<String> words = new HashSet<>(n);

    for (int i = 0; i < n; i++) {
      words.add(br.readLine().trim());
    }

    words.stream().sorted((a, b) -> {
      int aLength = a.length();
      int bLength = b.length();
      if (aLength == bLength) {
        return a.compareTo(b);
      } else {
        return aLength - bLength;
      }
    }).forEach(System.out::println);
  }

//  얜 다시 해봐야 함... 디교때문에 시간상 편하게 HashSet 이용
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = br.readLine().trim();
    }

    Arrays.sort(words);

    StringBuilder sb = new StringBuilder();
    Arrays.stream(words).forEach(word -> sb.append(word).append("\n"));

    System.out.print(sb);
  }
}
