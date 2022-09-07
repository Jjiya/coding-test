package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_1357 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    System.out.print(rev(rev(st.nextToken()) + rev(st.nextToken())));
  }

  static int rev(String revertTarget) {
    int revert = 0;
    for (int i = 0; i < revertTarget.length(); i++) {
      revert += (revertTarget.charAt(i) - 48) * (int) Math.pow(10, i);
    }

    return revert;
  }

  static int rev(int revertTarget) {
    return rev(String.valueOf(revertTarget));
  }
}
