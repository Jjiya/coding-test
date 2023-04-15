package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class S_1755 {
  // https://www.acmicpc.net/problem/1755
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    String[] numberToEnglish = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    PriorityQueue<NumberSet> englishNumber = new PriorityQueue<>(Comparator.comparing(n2 -> (n2.englishName)));

    for (int i = m; i <= n; i++) {
      int num = i;
      StringBuilder subSb = new StringBuilder();

      while (0 < num) {
        subSb.insert(0, numberToEnglish[num % 10]); // 1의 자리 숫자부터 글자로 변환하므로 앞에 넣어줘야 숫자에 맞는 글자로 만들어짐
        num /= 10;
      }

      englishNumber.offer(new NumberSet(i, subSb.toString()));
    }

    int count = 0;
    StringBuilder sb = new StringBuilder();

    while (!englishNumber.isEmpty()) {
      sb.append(englishNumber.poll().num).append(" ");

      if (++count % 10 == 0) {
        sb.append("\n");
      }
    }

    System.out.print(sb);
  }

  static class NumberSet {
    int num;
    String englishName;

    public NumberSet(int num, String englishName) {
      this.num = num;
      this.englishName = englishName;
    }
  }
}
