package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_10996 {
  // https://www.acmicpc.net/problem/10996
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.print('*');
      return;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n * 2; i++) {
      for (int j = 0; j < n; j++) {
        if(i % 2 == 0){
          if(j % 2 == 0){
            sb.append("*");
          }else{
            sb.append(" ");
          }
        }else{
          if(j % 2 == 0){
            sb.append(" ");
          }else{
            sb.append("*");
          }
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
