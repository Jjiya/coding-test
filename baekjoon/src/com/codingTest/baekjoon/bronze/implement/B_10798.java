package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_10798 {
  // https://www.acmicpc.net/problem/10798
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder[] sbList = new StringBuilder[15];

    for (int i = 0; i < 15; i++) {
      sbList[i] = new StringBuilder();
    }

    for (int i = 0; i < 5; i++) {
      String input = br.readLine();

      for (int j = 0; j < input.length(); j++) {
        sbList[j].append(input.charAt(j));
      }
    }

    StringBuilder rs = new StringBuilder();

    for (StringBuilder list : sbList) {
      rs.append(list);
    }

    System.out.print(rs);
  }
}