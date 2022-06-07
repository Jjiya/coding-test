package com.codingTest.baekjoon.silver.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class S_2869 {
  /** failure **/
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    double a = Double.parseDouble(st.nextToken());
    double b = Double.parseDouble(st.nextToken());
    double v = Double.parseDouble(st.nextToken());

    double day = Math.floor(v / (a - b));
    double count = day;
    if (v < day) {
      while (v < day) {
        day -= b;
        count--;
      }
    } else if (day < v) {
      while (day < v) {
        day += b;
        count++;
      }
    }


    System.out.print(count);
    System.out.print(day);

//a-b을 v로 나눈다음에
//    그 값을 b씩 더하면서 일수를 빼까?ㅋㅋㅋㅋㅋㅋ

  }

  //  당연하게도 시간초과
  public static void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    int day = 1;
    int up = a;
    while (up < v) {
      if (up < v) up += a - b;
      day++;
    }
    System.out.print(day);
  }
}
