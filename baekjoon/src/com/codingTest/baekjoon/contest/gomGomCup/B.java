package com.codingTest.baekjoon.contest.gomGomCup;

import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;

public class B {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    HashSet<String> dance = new HashSet<>();
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      String b = st.nextToken();

      if ((a.equals("ChongChong") || b.equals("ChongChong"))
          || (dance.contains(a) || dance.contains(b))
      ) {
        dance.add(a);
        dance.add(b);
      }
    }

    System.out.print(dance.size());
  }
}
