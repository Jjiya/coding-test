package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_1032 {
  // https://www.acmicpc.net/problem/1032
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    char[] pattern = br.readLine().toCharArray();

    for (int i = 1; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        if (pattern[j] != input.charAt(j)) {
          pattern[j] = '?';
        }
      }
    }

//    char[] 배열은 toString()이 문자열로 되나보네...
    System.out.print(pattern);
  }
}
