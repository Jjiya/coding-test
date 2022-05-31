package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_8393 {
  /**
   * 다른 풀이 보니까 얘도 알고리즘이 있네...
   * 1 ~ n 까지의 합 = n * (n+1) / 2
   * 근데 기존에 푼 문제보다 4ms 작고, 메모리는 16kb 차이뿐
   * 그래도 간단하다는 장점!
   *
   * @throws IOException
   */
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine().trim());

    System.out.print(input * (input + 1) / 2);
  }

  public static void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine().trim());

    int total = 0;
    for (int i = 1; i <= input; i++) {
      total += i;
    }

    System.out.print(total);
  }
}
