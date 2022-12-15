package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_1009 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (a % 10 == 0) {
        sb.append(10).append("\n");
        continue;
      }

      int dataNum = a % 10;
      for (int j = 1; j < b; j++) {
        dataNum = (dataNum * a) % 10;
      }

      sb.append(dataNum).append("\n");
    }

    System.out.print(sb);
  }
//   시간 급해서 거의 베꼈는데, 다시 해볼 것!
}
