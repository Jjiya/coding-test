package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_4999 {
  public void test() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(br.readLine().length() >= br.readLine().length() ? "go" : "no");
  }
}
