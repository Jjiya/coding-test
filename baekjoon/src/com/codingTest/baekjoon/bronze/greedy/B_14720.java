package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_14720 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()), count = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      String nextMilkShop = st.nextToken();
      if (count % 3 == 0 && nextMilkShop.equals("0")) {
        count++;
      } else if (count % 3 == 1 && nextMilkShop.equals("1")) {
        count++;
      } else if (count % 3 == 2 && nextMilkShop.equals("2")) {
        count++;
      }
    }

    System.out.print(count);
  }
}