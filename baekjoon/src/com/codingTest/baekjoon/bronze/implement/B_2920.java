package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_2920 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int diff = parseInt(st.nextToken()) - parseInt(st.nextToken());
    while (st.hasMoreTokens()) {
      int num = parseInt(st.nextToken());
      int nextNum = parseInt(st.nextToken());

      if (num - nextNum != diff) {
        System.out.print("mixed");
        return;
      } else {
        diff = num - nextNum;
      }
    }

    System.out.print(diff == 1 ? "descending" : "ascending");
  }

  static int parseInt(String st) {
    return Integer.parseInt(st);
  }
}

