package com.codingTest.baekjoon.silver.math;

import java.io.*;
import java.util.StringTokenizer;

public class S_2869 { // 22.06.13에 bronze로 바뀐 것 확인
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    double up = Double.parseDouble(st.nextToken());
    double down = Double.parseDouble(st.nextToken());
    double arrive = Double.parseDouble(st.nextToken());

    System.out.print((int) Math.ceil((arrive - up) / (up - down)) + 1);
  }

  // a-b을 v로 나눈다음에
  // 그 값을 b씩 더하면서 일수를 빼까?ㅋㅋㅋㅋㅋㅋ

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
