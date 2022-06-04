package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;
import java.util.StringTokenizer;

public class B_10818 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer n = Integer.parseInt(br.readLine().trim());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int min = Integer.parseInt(st.nextToken()), max = min;

    for (int i = 0; i < n - 1; i++) {
      int nextNum = Integer.parseInt(st.nextToken());

      if (nextNum < min) min = nextNum;
      if (max < nextNum) max = nextNum;
    }

    System.out.print(min + " " + max);
  }
}
