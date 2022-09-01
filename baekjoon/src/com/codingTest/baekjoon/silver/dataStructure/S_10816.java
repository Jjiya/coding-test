package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashMap;

public class S_10816 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> havingCard = new HashMap<>(n);

    for (String card : br.readLine().split("\\s")) {
      int cardNumber = Integer.parseInt(card);
      havingCard.put(cardNumber, havingCard.getOrDefault(cardNumber, 0) + 1);
    }

    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder(m);

    for (String card : br.readLine().split("\\s")) {
      sb.append(havingCard.getOrDefault(Integer.parseInt(card), 0)).append(" ");
    }

    System.out.print(sb);
  }
}
