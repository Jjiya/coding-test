package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Arrays;

public class S_11656 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    String[] sList = new String[s.length()];

    for (int i = 0; i < s.length(); i++) {
      sList[i] = s.substring(i);
    }
    Arrays.sort(sList);

    StringBuilder sb = new StringBuilder();
    for (String str : sList) {
      sb.append(str).append("\n");
    }

    System.out.print(sb);
  }
}
