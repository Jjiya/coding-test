package com.codingTest.baekjoon.bronze.oneDimensionalArray;

import java.io.*;
import java.util.Arrays;

public class B_2577 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int multiplication = 1;
    for (int i = 0; i < 3; i++) {
      multiplication *= Integer.parseInt(br.readLine().trim());
    }

    int[] numCountList = new int[10];
    Arrays.fill(numCountList, 0);

    while (0 < multiplication) {
      numCountList[multiplication % 10]++;
      multiplication /= 10;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numCountList.length; i++) {
      sb.append(numCountList[i]).append("\n");
    }

    System.out.print(sb);
  }
}
