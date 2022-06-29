package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_14487 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int sum = 0, max = 0;

    while(n-- > 0){
      int cost = Integer.parseInt(st.nextToken());
      max = Math.max(cost, max);
      sum += cost;
    }

    System.out.print(sum - max);
  }

  /*
    1 6 5 2 4
    1 2 3 4 5
     > > > >
        5 + 2 + 4 + 1 = 12
   */
}
