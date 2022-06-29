package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_2908 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    short[] finals = new short[2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2; i++) {
      short num = Short.parseShort(st.nextToken());
      short newNum = 0, digit = 100;
      for (int j = 0; j < 3; j++) {
        newNum += (num % 10) * digit;
        digit /= 10;
        num /= 10;
      }
      finals[i] = newNum;
    }

    System.out.print(Math.max(finals[0], finals[1]));

  }
}
