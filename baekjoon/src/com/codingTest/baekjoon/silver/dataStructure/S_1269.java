package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_1269 {
  // https://www.acmicpc.net/problem/1269
//  TODO : 이 방법 말고 다른 문제 풀이 찾아보기
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int aCount = Integer.parseInt(st.nextToken());
    int bCount = Integer.parseInt(st.nextToken());

    HashSet<Integer> aList = new HashSet<>(aCount);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < aCount; i++) {
      aList.add(Integer.parseInt(st.nextToken()));
    }

    int a_b = 0;
    int b_a = 0;

    HashSet<Integer> bList = new HashSet<>(bCount);
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < bCount; i++) {
      int bValue = Integer.parseInt(st.nextToken());
      bList.add(bValue);

      if (!aList.contains(bValue)) {
        b_a++;
      }
    }

    for (int aValue : aList) {
      if (!bList.contains(aValue)) {
        a_b++;
      }
    }

    System.out.print(a_b + b_a);
  }
}
