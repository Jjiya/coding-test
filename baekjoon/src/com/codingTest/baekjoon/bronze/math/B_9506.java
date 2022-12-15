package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.ArrayList;

public class B_9506 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    StringBuilder sb = new StringBuilder();

    while (!(input = br.readLine()).equals("-1")) {
      int num = Integer.parseInt(input);
      ArrayList<Integer> divisorList = getDivisorExceptOneself(num);

      int sum = 0;
      StringBuilder subSb = new StringBuilder();
      subSb.append(num).append(" = ");

      for (int i = 0; i < divisorList.size(); i++) {
        sum += divisorList.get(i);

        subSb.append(divisorList.get(i));
        if (i != divisorList.size() - 1) {
          subSb.append(" + ");
        }
      }
      if (sum == num) {
        sb.append(subSb).append("\n");
      } else {
        sb.append(num).append(" is NOT perfect.\n");
      }
    }

    System.out.print(sb);
  }

  static ArrayList<Integer> getDivisorExceptOneself(int num) {
    ArrayList<Integer> divisorList = new ArrayList<>(num);

    for (int i = num - 2; i > 1; i--) {
      if (num % i == 0) {
        divisorList.add(i);
      }
    }
    divisorList.add(1);
    divisorList.sort((o1, o2) -> {
      if (o1 > o2) {
        return 1;
      }
      if (o1 < o2) {
        return -1;
      }
      return 0;
    });

    return divisorList;
  }
}
