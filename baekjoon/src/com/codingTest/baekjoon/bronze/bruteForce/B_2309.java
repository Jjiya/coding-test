package com.codingTest.baekjoon.bronze.bruteForce;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class B_2309 {
//   지우기 편한데 속도는 느리네...
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> dwarf = new ArrayList<>();

    int sum = 0;
    for (int i = 0; i < 9; i++) {
      int height = Integer.parseInt(br.readLine());
      dwarf.add(height);
      sum += height;
    }

    int subSum = sum;

    outer:
    for (int i = 0; i < 8; i++) {
      subSum -= dwarf.get(i);
      if (subSum < 100) {
        subSum = sum;
        continue;
      }
      for (int j = i + 1; j < 9; j++) {
        if (subSum - dwarf.get(j) == 100) {
          dwarf.remove(j);
          dwarf.remove(i);
          break outer;
        }
      }
      subSum = sum;
    }

    StringBuilder sb = new StringBuilder();

    dwarf.stream().sorted().forEach(height -> sb.append(height).append("\n"));
    System.out.println(sb);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dwarf = new int[9];

    int sum = 0;
    for (int i = 0; i < 9; i++) {
      int height = Integer.parseInt(br.readLine());
      dwarf[i] = height;
      sum += height;
    }

    Arrays.sort(dwarf);

    int baseIdx = 0;
    int subIdx = 0;
    int subSum = sum;

    outer:
    while (subSum != 100) {
      if (100 <= subSum - dwarf[baseIdx]) {
        subSum -= dwarf[baseIdx];
        for (int i = baseIdx + 1; i < dwarf.length; i++) {
          if (100 == subSum - dwarf[i]) {
            subIdx = i;
            break outer;
          }
        }
        subSum = sum;
      }

      baseIdx++;
    }

    StringBuilder sb = new StringBuilder();

    for (int height : dwarf) {
      if (height != dwarf[baseIdx] && height != dwarf[subIdx]) {
        sb.append(height).append("\n");
      }
    }

    System.out.print(sb);
  }
}
