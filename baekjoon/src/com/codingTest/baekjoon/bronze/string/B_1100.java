package com.codingTest.baekjoon.bronze.string;

import java.io.*;

public class B_1100 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int whiteCount = 0;
    for (int i = 0; i < 8; i++) {
      String chess = br.readLine();

      if (chess.contains("F")) {
        for (int j = i % 2; j < 8; j += 2) {
          if (chess.charAt(j) == 'F') whiteCount++;
        }
      }
    }

    System.out.println(whiteCount);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int whiteCount = 0;
    for (int i = 0; i < 8; i++) {
      String chess = br.readLine();
      int fIndex = chess.indexOf("F");

      while (fIndex != -1) {
        if (i % 2 == 0 && fIndex % 2 == 0) { // 하얀 칸이 짝수 칸일때
          whiteCount++;
        } else if (i % 2 == 1 && fIndex % 2 == 1) {// 하얀 칸이 홀수 칸일때
          whiteCount++;
        }

        fIndex = chess.indexOf("F", ++fIndex);
      }
    }

    System.out.println(whiteCount);
  }
}
