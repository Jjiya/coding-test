package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.HashSet;

public class B_3059 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      String input = br.readLine();
      boolean[] alphabets = new boolean[26];

      int sum = 0;
      for (char alphabet : input.toCharArray()) {
        alphabets[alphabet - 65] = true;
      }
      for (int j = 0; j < 26; j++) {
        if (!alphabets[j]) sum += j + 65;
      }
      sb.append(sum).append("\n");
    }

    System.out.print(sb);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      String input = br.readLine();
      String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".replaceAll("[" + input + "]", "");

      HashSet<Character> addingList = new HashSet<>();
      int sum = 0;
      for (char alphabet : alphabets.toCharArray()) {
        if (!addingList.contains(alphabet)) {
          sum += alphabet;
          addingList.add(alphabet);
        }
      }
      sb.append(sum).append("\n");
    }

    System.out.print(sb);
  }
}
