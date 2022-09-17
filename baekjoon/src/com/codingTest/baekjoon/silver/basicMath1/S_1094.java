package com.codingTest.baekjoon.silver.basicMath1;

import java.io.*;

public class S_1094 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;

    String convertBinary = Integer.toBinaryString(Integer.parseInt(br.readLine()));

    for (char binary : convertBinary.toCharArray()) {
      if (binary == '1') count++;
    }

    System.out.print(count);
  }
}
/*
64  32  16  8 4 2 1
6   5   4   3 2 1 0
0   1   2   3 4 5 6

몇 번의 과정을 거치냐가 문제가 아닌, 몇 개의 막대가 필요하냐고 했으니 걍 2진법 변환 후 1인 개수 찾으면 됨
 */