package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.StringTokenizer;

public class S_1735 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a1 = Integer.parseInt(st.nextToken());
    int b1 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int a2 = Integer.parseInt(st.nextToken());
    int b2 = Integer.parseInt(st.nextToken());

    // 분수 합
    int sumA = (a1 * b2) + (a2 * b1);
    int sumB = b1 * b2;

    // 기약 분수 구하기(분수와 분모의 최대 공약수를 구해서 나누어주기)
    int gcd = gcd(sumA, sumB);

    System.out.print((sumA / gcd) + " " + (sumB / gcd));
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] numeric = new int[4];
    numeric[0] = Integer.parseInt(st.nextToken());
    numeric[1] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    numeric[2] = Integer.parseInt(st.nextToken());
    numeric[3] = Integer.parseInt(st.nextToken());

    // 최소 공배수
    int lcm = lcm(numeric[1], numeric[3]);

    int resultA = (numeric[0] * (lcm / numeric[1])) + (numeric[2] * (lcm / numeric[3]));

    // 분수 합의 기약 분수 구하기
    int gcd = gcd(resultA, lcm);
    resultA /= gcd;
    lcm /= gcd;

    System.out.println(resultA + " " + lcm);
  }

  /**
   * 최대 공약수
   *
   * @param b1
   * @param b2
   * @return
   */
  static int gcd(int b1, int b2) {
    if (b1 % b2 == 0) {
      return b2;
    } else {
      return gcd(b2, b1 % b2);
    }
  }

  /**
   * 최소 공배수
   *
   * @param b1
   * @param b2
   * @return
   */
  static int lcm(int b1, int b2) {
    return b1 * b2 / gcd(b1, b2);
  }
}
