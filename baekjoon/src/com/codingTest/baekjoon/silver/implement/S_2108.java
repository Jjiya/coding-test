package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class S_2108 {
  // https://www.acmicpc.net/problem/2108
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] num = new int[n];
    int[] count = new int[8002];

    int sum = 0, maxCount = 0;

    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(br.readLine());

      sum += num[i];
      count[num[i] + 4000]++;

      maxCount = Math.max(maxCount, count[num[i] + 4000]);
    }

    Arrays.sort(num);

    int frequentValue = -4002;

    for (int i = 0; i < count.length; i++) {
      if (count[i] != maxCount) {
        continue;
      }

      if (frequentValue == -4002) {
        frequentValue = i - 4000;
      } else {
        frequentValue = i - 4000;
        break;
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append(Math.round((float) sum / n)).append("\n");
    sb.append(num[n / 2]).append("\n");
    sb.append(frequentValue).append("\n");
    sb.append(num[n - 1] - num[0]);

    System.out.println(sb);
  }

  static class M1 {
    public void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      int[] nums = new int[n];
      HashMap<Integer, Integer> count = new HashMap<>();

      double sum = 0;

      int maxCount = -1;
      int maxCountNum = -1;
      for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(br.readLine());
        nums[i] = num;

        int numCount = count.getOrDefault(num, 0) + 1;
        count.put(num, numCount);

        if (maxCount < numCount) {
          maxCount = numCount;
          maxCountNum = num;
        }

        sum += num;
      }

      Arrays.sort(nums);

//     최빈값 구하기를 못함

      System.out.println(Math.round(sum / n));
      System.out.println(nums[n / 2]);
      System.out.println(maxCountNum);
      System.out.println(nums[n - 1] - nums[0]);
    }
  }
}
