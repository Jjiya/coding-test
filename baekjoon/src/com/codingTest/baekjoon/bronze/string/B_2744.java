package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_2744 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    StringBuilder sb = new StringBuilder();
//    lowerCase = upperCase + 32  &&  upperCase = lowerCase - 32
    for (int i = 0; i < input.length(); i++) {
      char chr = input.charAt(i);
      if (97 <= chr) {  // is lowerCase
        sb.append((char) (chr - 32));
      } else {
        sb.append((char) (chr + 32));
      }
    }

    System.out.print(sb);
  }
}
