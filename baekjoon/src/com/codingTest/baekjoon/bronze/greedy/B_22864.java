package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_22864 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int hoursFatigue = Integer.parseInt(st.nextToken()),    //시간 당 누적 피로도
        hoursWork = Integer.parseInt(st.nextToken()),       //시간 당 일 처리 양
        hoursRest = Integer.parseInt(st.nextToken()),       //휴식 시 시간 당 감소하는 피로도 양
        burnoutMinimum = Integer.parseInt(st.nextToken());  //번아웃 발생 최소 수치

    if (hoursFatigue > burnoutMinimum) {
      System.out.print(0);
      return;
    }

    int hoursOfDay = 24,
        fatigue = 0,  //피로도
        works = 0;

    while (hoursOfDay-- > 0) {
      if (fatigue + hoursFatigue > burnoutMinimum) {
        fatigue -= hoursRest;
        fatigue = Math.max(fatigue, 0);
      } else {
        fatigue += hoursFatigue;
        works++;
      }
    }

    System.out.print(works * hoursWork);
  }
}
