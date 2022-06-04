package com.codingTest.baekjoon.silver.function;

public class S_4673 {
  public static void test() {
    boolean[] selfNumberCheckList = new boolean[10000];

    int startNum = 1;
    while (startNum <= 10000) {
      int result = selfNumber(startNum);
      if (result <= 10000) {
        selfNumberCheckList[result - 1] = true;
      }
      startNum++;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < selfNumberCheckList.length; i++) {
      if (selfNumberCheckList[i] == false) sb.append(i + 1).append("\n");
    }

    System.out.print(sb);
  }

  public static int selfNumber(int num) {
    int sum = num;

    while (0 < num) {
      sum += num % 10;
      num /= 10;
    }

    return sum;
  }
}
