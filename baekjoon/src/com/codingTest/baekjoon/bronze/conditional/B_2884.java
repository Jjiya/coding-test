package com.codingTest.baekjoon.bronze.conditional;

import java.io.*;
import java.time.LocalTime;

public class B_2884 {

  //  메모리 14460 KB	시간 140 MS
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().trim().split("\\s");

    int hour = Integer.parseInt(input[0]);
    int minute = Integer.parseInt(input[1]);

    if (45 <= minute) {
      System.out.printf("%d %d", hour, minute - 45);
    } else if (minute < 45) {
      System.out.printf("%d %d", hour == 0 ? 23 : --hour, minute + 15);
    }
  }

  //  메모리 16396 KB	시간 152 MS
  public void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().trim().split("\\s");

    LocalTime setAlarmTime = LocalTime.of(Integer.parseInt(input[0]), Integer.parseInt(input[1])).minusMinutes(45);

    System.out.print(setAlarmTime.getHour() + " " + setAlarmTime.getMinute());
  }
}
