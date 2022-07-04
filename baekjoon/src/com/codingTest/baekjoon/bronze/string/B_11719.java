package com.codingTest.baekjoon.bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11719 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String tmp = "";
    while((tmp = br.readLine()) != null){
      sb.append(tmp).append("\n");
    }

    System.out.print(sb);
  }
}
