package com.codingTest.baekjoon.silver.basicMath1;

import java.io.*;

public class S_2839 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int deliveryKG = Integer.parseInt(br.readLine());
    int sugar5KG = 5, sugar3KG = 3;

    if (deliveryKG % sugar5KG == 0) {
      System.out.print(deliveryKG / sugar5KG);
    } else if ((deliveryKG % sugar5KG) % sugar3KG == 0) {
      System.out.print(deliveryKG / sugar5KG + (deliveryKG / sugar5KG) / sugar3KG);
    } else if ((deliveryKG - sugar5KG) % sugar3KG == 0) {
      System.out.print((deliveryKG - sugar5KG) / sugar3KG + 1);
    } else if (deliveryKG % sugar3KG == 0) {
      System.out.print(deliveryKG / sugar3KG);
    } else {
      System.out.print(-1);
    }
  }
}
