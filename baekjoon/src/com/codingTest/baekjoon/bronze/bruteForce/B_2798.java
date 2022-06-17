package com.codingTest.baekjoon.bronze.bruteForce;

import java.io.*;
import java.util.*;

public class B_2798 {
//  시간 복잡도 줄여서 다시 풀기!!
  public static void test() throws IOException {
    /*
     * sorting desc
     * pick [0] and m - [0]
     * filter what [0] + [i] isn't grater than m and pick MAX i
     * then also [0] + [max_i] + [j] like step 3 and choose first.
     *
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    ArrayList<Integer> cards = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      cards.add(Integer.parseInt(st.nextToken()));
    }

    cards.sort(Collections.reverseOrder());
    int cardSum = cards.get(0);

    outer:
    for (int i = 1; i < cards.size(); i++) {
      if (cardSum + cards.get(i) <= m) {
        for (int j = i + 1; j < cards.size(); j++) {
          if (cardSum + cards.get(i) + cards.get(j) <= m) {
            cardSum += cards.get(i) + cards.get(j);
            break outer;
          }
        }
      }
    }
    System.out.print(cardSum);
  }

//  왕왕 for문
  public static void test1() throws IOException {
    /*
     * sorting desc
     * pick [0] and m - [0]
     * filter what [0] + [i] isn't grater than m and pick MAX i
     * then also [0] + [max_i] + [j] like step 3 and choose first.
     *
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    ArrayList<Integer> cards = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      cards.add(Integer.parseInt(st.nextToken()));
    }

    cards.sort(Collections.reverseOrder());
    int cardSum = 0;
    for (int i = 0; i < cards.size(); i++) {
      int max = 0;
      for (int j = i + 1; j < cards.size(); j++) {
        int pick1 = cards.get(i) + cards.get(j);
        if (pick1 <= m) {
          for (int k = j + 1; k < cards.size(); k++) {
            int pick2 = pick1 + cards.get(k);
            if (pick2 <= m && max < pick2) {
              max = pick2;
            }
          }
        }
      }
      if (cardSum < max) cardSum = max;
    }
    System.out.print(cardSum);

  }
}
