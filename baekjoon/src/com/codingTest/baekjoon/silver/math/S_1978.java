package com.codingTest.baekjoon.silver.math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_1978 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> primeList = new ArrayList<>(n);
    primeList.add(2);
    primeList.add(3);

    short count = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    while (0 < n--) {
      int num = Integer.parseInt(st.nextToken());

      if (primeList.contains(num)) {
        count++;
        continue;
      }

      boolean isPrime = false;
      for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
          isPrime = false;
          break;
        } else {
          isPrime = true;
        }
      }
      if (isPrime) {
        primeList.add(num);
        count++;
      }
    }
    System.out.print(count);
  }
}
