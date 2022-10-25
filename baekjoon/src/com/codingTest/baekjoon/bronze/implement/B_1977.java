package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_1977 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    int sum = 0;
    int firstNum = -1;
    int num = 1;
    while (true) {
      int square = (int) Math.pow(num++, 2);
      if (square < m) {
        continue;
      }
      if (square <= n) {
        sum += square;
        if (firstNum == -1) {
          firstNum = square;
        }
      } else {
        break;
      }
    }

    if (sum == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sum);
      System.out.print(firstNum);
    }
  }
}
