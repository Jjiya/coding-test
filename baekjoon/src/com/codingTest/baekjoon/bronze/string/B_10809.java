package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.Arrays;

public class B_10809 {
  // 메모리: 14232KB  시간: 132ms
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (int i = 'a'; i <= 'z'; i++) {
      sb.append(input.indexOf(Character.toString(i))).append(" ");
    }

    System.out.print(sb);
  }

  // 메모리: 14276KB  시간: 140ms
  public static void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();

    int[] includes = new int[26];
    Arrays.fill(includes, -1);

    for (int i = 0; i < input.length; i++) {
      int charIdx = (int) input[i] - (int) 'a';
      if (includes[charIdx] == -1) includes[charIdx] = i;
    }

    StringBuilder sb = new StringBuilder();
    for (int count : includes) {
      sb.append(count).append(" ");
    }
    System.out.print(sb);
  }
}
