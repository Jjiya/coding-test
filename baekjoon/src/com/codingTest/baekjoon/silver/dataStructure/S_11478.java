package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashSet;

public class S_11478 {
  // https://www.acmicpc.net/problem/11478
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> result = new HashSet<>();

    String s = br.readLine();
    int sLength = s.length();

    for (int i = 1; i <= sLength; i++) {
      for (int j = 0; j <= sLength - i; j++) {
        result.add(s.substring(j, j + i));
      }
    }

    System.out.print(result.size());
  }
}
