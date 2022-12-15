package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_1037 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.print((int) Math.pow(Integer.parseInt(br.readLine()), 2));
      return;
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int min = 1000001, max = 1;

    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      if(num <min){
        min = num;
      }

      if(max <num){
        max = num;
      }
    }

    System.out.print(min * max);
  }

  //  a의 약수가 모두 주어지기때문에 최소 공배수로 풀면 틀린다고 함. (실제로 2\n 4 2 의 경우 최소 공배수가 4가 됨)
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long a;

    if (n == 1) {
      a = Integer.parseInt(br.readLine());
      System.out.print(a * a);
      return;
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n - 1; i++) {
      long b = Integer.parseInt(st.nextToken());
      //  최대 공배수
      a = (a * b) / gcd(a, b);
    }

    System.out.println(a);
  }


  //  최대 공약수
  static long gcd(long a, long b) {
    long r;
    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }

    return a;
  }
}
