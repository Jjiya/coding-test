package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_2902 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), "-");

    StringBuilder sb = new StringBuilder();
    while (st.hasMoreTokens()) {
      sb.append(st.nextToken().charAt(0));
    }

    System.out.print(sb);
  }
}
