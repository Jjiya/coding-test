package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_2605 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int studentCount = Integer.parseInt(br.readLine());

    LinkedList<Integer> lineUp = new LinkedList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < studentCount; i++) {
      int getNum = Integer.parseInt(st.nextToken());

      lineUp.add(i - getNum, i + 1);
    }

    StringBuilder sb = new StringBuilder();
    lineUp.forEach(sequence -> sb.append(sequence).append(" "));

    System.out.print(sb);
  }
}
