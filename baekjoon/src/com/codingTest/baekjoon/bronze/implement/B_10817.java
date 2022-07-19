package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.*;

public class B_10817 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] nums = new int[3];

    for (int i = 0; i < 3; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);

    System.out.print(Math.max(Math.min(nums[1], nums[2]), nums[0]));
  }
}
