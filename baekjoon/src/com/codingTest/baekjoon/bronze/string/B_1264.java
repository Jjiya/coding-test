package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.Locale;

public class B_1264 {
  // https://www.acmicpc.net/problem/1264
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    StringBuilder sb = new StringBuilder();
    while (true) {
      String input = br.readLine();

      if ("#".equals(input)) {
        break;
      }

      int vowelCount = 0;

      for (char letter : input.toLowerCase(Locale.ROOT).toCharArray()) {
        for (char vowelLetter : vowel) {
          if (letter == vowelLetter) {
            vowelCount++;
            break;
          }
        }
      }

      sb.append(vowelCount).append("\n");
    }

    System.out.print(sb);
  }
}
