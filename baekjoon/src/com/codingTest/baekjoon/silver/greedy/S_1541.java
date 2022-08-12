package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_1541 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringTokenizer st;
    int sum = 0;

    if (input.contains("-")) {
      st = new StringTokenizer(input, "-");

      boolean isFirst = true;
      while (st.hasMoreTokens()) {
        int plusNums = 0;

        StringTokenizer subSt = new StringTokenizer(st.nextToken(), "+");

        while (subSt.hasMoreTokens()) {
          plusNums += Integer.parseInt(subSt.nextToken());
        }

        if (isFirst) {
          sum += plusNums;
          isFirst = false;
        } else {
          sum -= plusNums;
        }
      }
    } else {
      st = new StringTokenizer(input, "+");

      while (st.hasMoreTokens()) {
        sum += Integer.parseInt(st.nextToken());
      }
    }

    System.out.print(sum);
  }
}
