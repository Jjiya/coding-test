package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_2445 {
  StringBuilder sb = new StringBuilder();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int maxWidth = 2 * n;
    printRibbon(maxWidth, 1);

    System.out.println(sb);
  }

  void printRibbon(int maxWidth, int index) {
    StringBuilder subSb = new StringBuilder();
    for (int i = 0; i < maxWidth; i++) {
      subSb.append((i < index || maxWidth - index <= i) ? "*" : " ");
    }
    subSb.append("\n");
    sb.append(subSb);

    if (index != (maxWidth / 2)) {
      printRibbon(maxWidth, index + 1);
      sb.append(subSb);
    }
  }
}