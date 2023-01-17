package com.codingTest.baekjoon.gold.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class G_1744 {
  // https://www.acmicpc.net/problem/1744
  /*
    반례: https://www.acmicpc.net/board/view/106796
    고려했어햐 했는데 안한 것들
    1. 음수끼리 곱하면 양수가 된다.
    2. 0은 더하는데만 쓰는 것이 아닌 양수가 되지 못한 음수에 곱하면 된다.
    3. 1이 2개 이상일 때는 곱하는 것보다 더하는 것이 낫다.
   */
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> negativeList = new ArrayList<>(n);
    ArrayList<Integer> positiveList = new ArrayList<>(n);

    int sum = 0;

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      // 0은 저장 생략
      if (1 < num) {
        positiveList.add(num);
      } else if (num < 1) {
        negativeList.add(num);
      } else {
        sum++;
      }
    }

    positiveList.sort(Comparator.reverseOrder());
    negativeList.sort(Comparator.naturalOrder());


    if (1 < positiveList.size()) {
      for (int i = 0; i < positiveList.size() - 1; i += 2) {
        sum += positiveList.get(i) * positiveList.get(i + 1);
      }
    }

    if (positiveList.size() % 2 == 1) {
      sum += positiveList.get(positiveList.size() - 1);
    }

    if (1 < negativeList.size()) {
      for (int i = 0; i < negativeList.size() - 1; i += 2) {
        sum += negativeList.get(i) * negativeList.get(i + 1);
      }
    }

    if (negativeList.size() % 2 == 1) {
      sum += negativeList.get(negativeList.size() - 1);
    }

    System.out.println(sum);
  }
}
