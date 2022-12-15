package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_3009 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> coordinate = new HashMap<>(6);

    StringTokenizer st;
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 2; j++) {
        String coor = st.nextToken();
        coordinate.put(coor, coordinate.getOrDefault(coor,0) + 1);
      }
    }


  }
}
