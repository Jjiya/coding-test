package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_11718 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String tmp = "";
    while ((tmp = br.readLine()) != null) {
      sb.append(tmp).append("\n");
    }
    System.out.print(sb);
  }
}
