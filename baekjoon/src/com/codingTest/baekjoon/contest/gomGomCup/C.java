package com.codingTest.baekjoon.contest.gomGomCup;

import java.io.*;
import java.util.StringTokenizer;

/* 풀다가 대회 시간 종료
  https://www.acmicpc.net/contest/view/895
 */
public class C {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] gomCount = new int[3];
    int[] ticketCount = new int[3];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 3; i++) {
      gomCount[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    int eatCount = 0;

    for (int i = 0; i < 3; i++) {
      int gom = gomCount[i];
      int ticket = Integer.parseInt(st.nextToken());

      gomCount[i] = Math.max(gomCount[i] - ticket, 0);

      ticketCount[i] = Math.max(ticket - gom, 0);

      eatCount += gom - gomCount[i];
    }


    System.out.print(eatCount);
  }
}
