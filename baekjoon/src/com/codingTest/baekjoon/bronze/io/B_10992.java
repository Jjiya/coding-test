package com.codingTest.baekjoon.bronze.io;

import java.io.*;

public class B_10992 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      int max = i * 2 - 1;
      if (i != n) {
        for (int j = 0; j < n - i; j++) {
          sb.append(" ");
        }
        for (int j = 0; j < max; j++) {
          if (j == 0 || j == max - 1) {
            sb.append("*");
          } else {
            sb.append(" ");
          }
        }
      }else{  // 마지막 줄
        for (int j = 0; j < max; j++) {
          sb.append("*");
        }
      }// end outer if
      
      sb.append("\n");
    }// end for

    System.out.print(sb);
  }
}
