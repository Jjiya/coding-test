package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_19564 {
  // https://www.acmicpc.net/problem/19564
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int count = 1;

//    전의 글자와 동일하거나 같으면 알파벳 묶음을 다시 입력해야함
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) <= s.charAt(i - 1)) {
        count++;
      }
    }

    System.out.print(count);
  }
}
