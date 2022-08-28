package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class S_1158 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    boolean[] isDelete = new boolean[n + 1];
    int count = 0;
    int num = 0;

    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (count < n) {
      int increment = 0;

      while (increment < k) {
        boolean isDeleted = true;
        while (isDeleted) {
          num++;

          if (num > n) {
            num -= n;
          }

          if (!isDelete[num]) {
            increment++;
            isDeleted = false;
          }
        }
      }

      isDelete[num] = true;
      sb.append(num);

      count++;
      if (count != n) {
        sb.append(", ");
      }
    }

    System.out.print(sb + ">");
  }
}
