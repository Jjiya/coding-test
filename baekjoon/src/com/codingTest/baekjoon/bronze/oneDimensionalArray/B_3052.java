package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;
import java.util.HashMap;

public class B_3052 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<Integer, Integer> remainderMap = new HashMap<>();

    String tmp = "";

    while ((tmp = br.readLine()) != null) {
      int remainder = Integer.parseInt(tmp) % 42;
      remainderMap.put(remainder, 1);
    }

    System.out.print(remainderMap.size());
  }
}
