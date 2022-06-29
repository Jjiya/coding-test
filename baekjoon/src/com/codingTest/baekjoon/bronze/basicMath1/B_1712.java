package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class B_1712 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    double a = Double.parseDouble(st.nextToken());
    double b = Double.parseDouble(st.nextToken());
    double c = Double.parseDouble(st.nextToken());

    int sales = 1;
    boolean possible = false;
    while (sales <= 100) {
      if (b * sales < c * sales) {
        possible = true;
        break;
      }
      sales++;
    }
    if (!possible) {
      System.out.print(-1);
      return;
    }

    int interval = 10 * ((a + "").length() - (c + "").length());
    while (interval < a) {
      if (a + (b * sales) < c * sales * interval) {
        break;
      } else {
        interval *= 10;
      }
    }

    System.out.print(interval + sales);
  }
}