package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.HashMap;

// TODO 개선하기
public class S_11652 {
  // https://www.acmicpc.net/problem/11652
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> cardList = new HashMap<>();

    int max = 0;
    String maxKey = null;
    for (int i = 0; i < n; i++) {
      String key = br.readLine();

      int count = cardList.getOrDefault(key, 0);

      count++;

      cardList.put(key, count);

      if (max < count) {
        max = count;
        maxKey = key;
      } else if (max == count && Long.parseLong(key) < Long.parseLong(maxKey)) {
        maxKey = key;
      }
    }

    System.out.print(maxKey);
  }

  static class Card implements Comparable<Card> {
    int number;
    int count = 0;

    public Card(int number) {
      this.number = number;
    }

    void addOne() {
      this.count++;
    }

    @Override
    public int compareTo(Card other) {
      return other.count - this.count;
    }
  }
}
