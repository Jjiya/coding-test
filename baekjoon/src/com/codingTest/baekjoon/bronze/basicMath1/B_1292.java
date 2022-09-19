package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class B_1292 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[] sum = new int[b + 1];
    sum[1] = 1;

    int num = 2, idx = 2;
    
//    누적 합계 저장
    while (idx <= b) {
      for (int j = 0; j < num; j++) {
        sum[idx] = sum[idx - 1] + num;
        idx++;

        if (idx > b) {
          break;
        }
      }

      num++;
    }

    System.out.print(sum[b] - sum[a - 1]);
  }
}
