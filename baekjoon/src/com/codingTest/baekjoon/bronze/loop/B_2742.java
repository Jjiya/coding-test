package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_2742 {
  public static void test() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer n = Integer.parseInt(br.readLine().trim());
    StringBuilder sb = new StringBuilder();

    for (int i = n; i >= 1; i--) {
      sb.append(i).append("\n");
    }

    System.out.print(sb);
  }
}
