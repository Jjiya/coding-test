package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_2864 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

//    최소 값 = 모든 6을 5로 바꾼 값
    int[] minimum = new int[2];
//    최대 값 = 모든 5를 6으로 바꾼 값
    int[] maximum = new int[2];

    for (int i = 0; i < 2; i++) {
      String str = st.nextToken();
      for (int j = 0; j < str.length(); j++) {
        int num = Integer.parseInt(String.valueOf(str.charAt(j)));
        int digit = (int) Math.pow(10, str.length() - j - 1);

        if (num == 5 || num == 6) {
          minimum[i] += 5 * digit;
          maximum[i] += 6 * digit;
        } else {
          minimum[i] += num * digit;
          maximum[i] += num * digit;
        }
      }
    }

    System.out.print((minimum[0] + minimum[1] + " " + (maximum[0] + maximum[1])));
  }
}
