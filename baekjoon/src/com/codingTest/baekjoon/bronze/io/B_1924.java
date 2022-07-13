package com.codingTest.baekjoon.bronze.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1924 {
  /* m월 d일일 때
   (1 ~ m-1월까지의 날짜 합산
   +
   d일)
   % 7
   = 나머지
   0  ~  6
   일  ~ 토
 */
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int month = Integer.parseInt(st.nextToken()), day = Integer.parseInt(st.nextToken());
    //                        2   3   4    5    6    7    8    9   10   11   12
    int[] monthOfBeforeDay = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    String[] dayOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    int daySum = day;
    if (month > 1) {
      daySum += monthOfBeforeDay[month - 2];
    }

    System.out.print(dayOfTheWeek[daySum % 7]);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int month = Integer.parseInt(st.nextToken()), day = Integer.parseInt(st.nextToken());
    int[] monthOfLastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] dayOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    int daySum = day;
    for (int i = 0; i < month - 1; i++) {
      daySum += monthOfLastDay[i];
    }

    System.out.print(dayOfTheWeek[daySum % 7]);
  }
}
