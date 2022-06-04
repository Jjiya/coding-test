package com.codingTest.baekjoon.bronze.conditional;

import java.io.*;

public class B_2753 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer input = Integer.parseInt(br.readLine().trim());
    if((input % 4 == 0 && input % 100 != 0) || (input % 400 == 0)){
      System.out.print(1);
    }else{
      System.out.print(0);
    }
  }
}
