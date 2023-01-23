package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.HashMap;

public class B_1076 {
  // https://www.acmicpc.net/problem/1076
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, int[]> list = new HashMap<>();

    list.put("black", new int[]{0, 1});
    list.put("brown", new int[]{1, 10});
    list.put("red", new int[]{2, 100});
    list.put("orange", new int[]{3, 1_000});
    list.put("yellow", new int[]{4, 10_000});
    list.put("green", new int[]{5, 100_000});
    list.put("blue", new int[]{6, 1_000_000});
    list.put("violet", new int[]{7, 10_000_000});
    list.put("grey", new int[]{8, 100_000_000});
    list.put("white", new int[]{9, 1_000_000_000});

    long value = list.get(br.readLine())[0] * 10 + list.get(br.readLine())[0];
    System.out.println(value * list.get(br.readLine())[1]);
  }
}
