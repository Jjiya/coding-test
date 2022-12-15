package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2501 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    ArrayList<Integer> divisor = getDivisor(n, k);
    if (divisor.size() <= k - 1) {
      System.out.print(0);
    } else {
      System.out.print(divisor.get(k - 1));
    }
  }

  static ArrayList<Integer> getDivisor(int number, int maximum) {
    ArrayList<Integer> divisorList = new ArrayList<>();
    divisorList.add(1);
    for (int i = 2; i <= number; i++) {
      if (number % i == 0) {
        divisorList.add(i);
      }
      if (divisorList.size() == maximum) {
        break;
      }
    }
    return divisorList;
  }
}
