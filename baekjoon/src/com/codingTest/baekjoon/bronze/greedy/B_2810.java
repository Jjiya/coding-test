package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_2810 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int seatsCount = Integer.parseInt(br.readLine());
    String seats = br.readLine();

    int cupHolder = 1;  //마지막 자리

    for (int i = 0; i < seatsCount; i++) {
      char seat = seats.charAt(i);

      if (seat == 'S') {
        cupHolder++;
      } else if (seat == 'L') {
        cupHolder++;
        i++;
      }
    }
    System.out.print(Math.min(cupHolder, seatsCount));
  }
}
