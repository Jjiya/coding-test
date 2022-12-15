package com.codingTest.baekjoon.silver.math;

import java.io.*;

// 풀이 참고 https://st-lab.tistory.com/72
// https://puleugo.tistory.com/27?category=935212
public class S_2839 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int deliveryKG = Integer.parseInt(br.readLine());
    int sugar5KG = 5, sugar3KG = 3;

    if (deliveryKG % 5 == 0) {
      System.out.println(deliveryKG / sugar5KG);
      return;
    }

    int count = 0;
    while (0 < deliveryKG) {
      deliveryKG -= sugar3KG;
      count++;
      if (deliveryKG % sugar5KG == 0) {
        count += deliveryKG / sugar5KG;
        deliveryKG %= sugar5KG;
      } else if (deliveryKG == 1 || deliveryKG == 2) {
        count = -1;
        break;
      }
    }

    System.out.print(count);
  }
}
