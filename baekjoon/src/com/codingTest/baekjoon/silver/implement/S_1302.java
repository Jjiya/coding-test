package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S_1302 {
  // https://www.acmicpc.net/problem/1302
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> book = new HashMap<>(n);

    for (int i = 0; i < n; i++) {
      String name = br.readLine();

      int sale = book.getOrDefault(name, 0) + 1;
      book.put(name, sale);
    }

    List<String> keySet = new ArrayList<>(book.keySet());

    keySet.sort((book1, book2) -> {
      int compare = book.get(book2).compareTo(book.get(book1));

      return compare == 0 ? book1.compareTo(book2) : compare;
    });

    System.out.print(keySet.get(0));
  }
}
