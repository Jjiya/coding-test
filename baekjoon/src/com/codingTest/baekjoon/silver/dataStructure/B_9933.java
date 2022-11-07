package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashSet;

/*
1. 펠린드롬 문자이거나
2. 뒤집은 문자가 입력에 존재하는 경우가 답임...
 */
public class B_9933 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashSet<String> password = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String pw = br.readLine();
      if (password.contains(pw)) {
        System.out.print(pw.length() + " " + pw.charAt(pw.length() / 2));
        return;
      } else {
        StringBuilder reversePw = new StringBuilder();
        for (int j = pw.length() - 1; j >= 0; j--) {
          reversePw.append(pw.charAt(j));
        }

        if (pw.equals(reversePw.toString())) {
          System.out.print(pw.length() + " " + pw.charAt(pw.length() / 2));
          return;
        }
        pw = reversePw.toString();

        if (password.contains(pw)) {
          System.out.print(pw.length() + " " + pw.charAt(pw.length() / 2));
          return;
        }
        password.add(pw);
      }
    }
  }
}
