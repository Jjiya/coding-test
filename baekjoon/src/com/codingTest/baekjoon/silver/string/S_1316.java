package com.codingTest.baekjoon.silver.string;

import java.io.*;
import java.util.ArrayList;

public class S_1316 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    short n = Short.parseShort(br.readLine());

    short count = 0;

    for (short i = 0; i < n; i++) {
      char[] chars = br.readLine().toCharArray();
      ArrayList<Character> check = new ArrayList<>(chars.length);

      boolean checkGroupString = false;

      for (short j = 0; j < chars.length; j++) {
        if (check.contains(chars[j]) && !check.get(check.size() - 1).equals(chars[j])) {
          checkGroupString = false;
          break;
        } else {
          checkGroupString = true;
          check.add(chars[j]);
        }
      }
      if (checkGroupString) count++;
    }

    System.out.print(count);
  }
}
