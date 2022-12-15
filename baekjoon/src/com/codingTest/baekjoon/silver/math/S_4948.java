package com.codingTest.baekjoon.silver.math;

import java.io.*;
import java.util.ArrayList;

public class S_4948 {
  public static void test() throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    int n = -1;
//    StringBuilder sb = new StringBuilder();
//    while ((n = Integer.parseInt(br.readLine())) != 0) {
//      int count = 0;
//      for (int i = n + 1; i <= n * 2; i++) {
//        if (isPrime(i)) count++;
//      }
//      sb.append(count).append("\n");
//    }
//
//    System.out.print(sb);

    int n = 48;
    ArrayList<Integer> primeList = getPrimeList(n);
    int sum = -1;

    /** 2 3 5 7
     * [i=0]
     * 2 j=0
     * 3 j=1
     * 5 j=2
     * 7 j=3
     ************
     * [i=1]
     * 2,3 j=0,1
     * 2,5 j=0,2
     * 2,7 j=0,3
     *
     * 3,5 j=1,2
     * 3,7 j=1,3
     *
     * 5,7 j=2,3
     ************
     * [i=2]
     * 2,3,5 j=0,1,2
     * 2,3,7 j=0,1,3
     * 2,5,7 j=0,2,3
     *
     * 3,5,7 j=1,2,3
     ************
     * [i=3]
     * 2,3,5,7 j=0,1,2,3
     */

    for (int i = 0; i < primeList.size(); i++) {
      int multiple = 1;
//      while로?

      for (int j = 0; j < primeList.size() - i; j++) {
        System.out.print(" * " + primeList.get(j));
        multiple *= primeList.get(j);
      }
      System.out.println("\n" + i + ": " + multiple + "---\n");
    }


//    for (int i = primeList.size(); i > 0; i--) {
//      int multiple = 1;
//      for (int j = 0; j < i; j++) {
//        System.out.printf("%d * %d", multiple, primeList.get(j));
//        multiple *= primeList.get(j);
//        System.out.println(" = " + multiple);
//      }
//      if (i % 2 == 0) {
//        System.out.printf("sum: %d - (%d / %d) >> (%d)", sum, n, multiple, n / multiple);
//        sum -= (n / multiple);
//      } else {
//        System.out.printf("sum: %d + (%d / %d) >> (%d)", sum, n, multiple, n / multiple);
//        sum += (n / multiple);
//      }
//      System.out.println(" = " + sum);
//    }

    System.out.println(sum);
  }

  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = -1;
    StringBuilder sb = new StringBuilder();
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      int count = 0;
      for (int i = n + 1; i <= n * 2; i++) {
        if (isPrime(i)) count++;
      }
      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }

  /**
   * 1 ~ maxNum까지의 소수를 반환함
   * <p>
   * 포함 배제의 원리 이용하여 소수 개수 구하기 진행하다가 맒...
   * 참고: https://terms.naver.com/entry.naver?docId=3405213&ref=y&cid=47324&categoryId=47324
   *
   * @param maxNum 최대 수
   * @return ArrayList<Integer> 소수 list
   */
  public static ArrayList<Integer> getPrimeList(int maxNum) {
    maxNum = (int) Math.sqrt(maxNum);

    ArrayList<Integer> primeSet = new ArrayList<>(maxNum);
    if (2 <= maxNum) primeSet.add(2);
    if (3 <= maxNum) primeSet.add(3);

    for (int i = 5; i <= maxNum; i++) {
      if (isPrime(i)) primeSet.add(i);
    }
    return primeSet;
  }

  public static boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
}
