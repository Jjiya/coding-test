package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.Stack;

public class S_10773 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.parseInt(br.readLine());
    int[] money = new int[k];
    int writeIndex = 0;

    while (k-- > 0) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) {
        money[--writeIndex] = num;
      } else {
        money[writeIndex++] = num;
      }
    }

    int sum = 0;

    for (int num : money) {
      sum += num;
    }

    System.out.print(sum);
  }


  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> accounts = new Stack<>();

    int k = Integer.parseInt(br.readLine());

    while (k-- > 0) {
      int money = Integer.parseInt(br.readLine());
      if (0 < money) {
        accounts.push(money);
      } else {
        accounts.pop();
      }
    }

    if (accounts.isEmpty()) {
      System.out.print(0);
    } else {
      int sum = 0;

      while (!accounts.isEmpty()) {
        sum += accounts.pop();
      }

      System.out.print(sum);
    }
  }
}
