package com.codingTest.baekjoon.silver.dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.io.*;
import java.util.StringTokenizer;

public class S_11866 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> people = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      people.offer(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (!people.isEmpty()) {
      for (int i = 0; i < k; i++) {
        int remove = people.poll();
        if (i != k - 1) {
          people.offer(remove);
        } else {
          sb.append(remove);
        }
      }
      if (!people.isEmpty()) {
        sb.append(", ");
      } else {
        sb.append(">");
      }
    }

    System.out.print(sb);
  }


  public void test1() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();

    boolean[] dieList = new boolean[n + 1];

    StringBuilder sb = new StringBuilder();
    int count = 0;
    int dieIdx = k;
    while (count <= n) {
      while (dieList[dieIdx]) {
        dieIdx++;
        if (dieIdx == n) {
          dieIdx -= n;
        }
      }
      dieList[dieIdx] = true;
      sb.append(dieIdx).append(", ");
      int increase = 0;
      while (increase == k) {
        if (!dieList[dieIdx]) {
          increase++;
        } else {
          dieIdx++;
        }
      }
      dieIdx += k;
      if (n < dieIdx) {
        dieIdx -= n;
      }
      count++;
    }
    System.out.println(sb);
  }
}