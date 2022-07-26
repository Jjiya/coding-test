package com.algorithms.basic.DoIt.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Chapter01_1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine()), d = Integer.parseInt(br.readLine());

    getRunTime("max4_1", a, b, c, d);
    getRunTime("max4_2", a, b, c, d);
    getRunTime("max4_3", a, b, c, d);

//    int[] numbers = {1, 20, 39, 3204, 93, 19, 100, 33, 9};
//    getRunTime("sum_1", numbers);
//    getRunTime("sum_2", numbers);

//    System.out.println(min3(a, b, c));
  }


  static int min3(int a, int b, int c) {
    int min = a;

    if (b < min) min = b;

    if (c < min) min = c;

    return min;
  }

  static void getRunTime(String fName, int a, int b, int c, int d) {
    long start = new Date().getTime();
    int repetition = 1000;

    System.out.println("\n--------[" + fName + "]--------");

    Object o = switch (fName) {
      case "max4_1" -> {
        int max = 0;
        for (int i = 0; i < repetition; i++) {
          max = max4_1(a, b, c, d);
        }
        yield max;
      }
      case "max4_2" -> {
        int max = 0;
        for (int i = 0; i < repetition; i++) {
          max = max4_2(a, b, c, d);
        }
        yield max;
      }
      case "max4_3" -> {
        int max = 0;
        for (int i = 0; i < repetition; i++) {
          max = max4_3(a, b, c, d);
        }
        yield max;
      }
      default -> -1;
    };

    System.out.println("answer: " + o);

    long end = new Date().getTime();

    System.out.println("--------" + repetition + "번 반복후 걸린 시간(" + (end - start) + ")--------");
  }

  static void getRunTime(String fName, int[] numbers) {
    long start = new Date().getTime();

    System.out.println("\n--------[" + fName + "]--------");
//    System.out.println("시작: " + start);

    Object o = switch (fName) {
      case "sum_1" -> sum_1(numbers);
      case "sum_2" -> sum_2(numbers);
      default -> -1;
    };

    System.out.println("answer: " + o);

    long end = new Date().getTime();
//    System.out.println("종료: " + end);

    System.out.println("--------(" + ((end - start)) + ")--------");
  }

  static int sum_1(int[] numbers) {
    int sum = 0;
    for (int num : numbers) {
      sum += num;
    }
    return sum;
  }

  static int sum_2(int[] numbers) {
    int sum = 0;

    for (int i = 0; i < numbers.length / 2; i++) {
      sum += (numbers[i] + numbers[numbers.length - i - 1]);
    }

    return sum;
  }


  static int max4_1(int a, int b, int c, int d) {
    if (b > a) {
      if (b > c) {
        if (b > d) {
          return b;
        }
      }
    }

    if (c > a) {
      if (c > b) {
        if (c > d) {
          return c;
        }
      }
    }

    if (d > a) {
      if (d > b) {
        if (d > c) {
          return d;
        }
      }
    }

    return a;
  }

  static int max4_2(int a, int b, int c, int d) {
    int max;
    if (a > b) {
      max = a;
    } else {
      max = b;
    }

    if (c > d) {
      if (c > max) {
        max = c;
      }
    } else if (d > max) {
      max = d;
    }

    return max;
  }

  static int max4_3(int a, int b, int c, int d) {
    int max = Math.max(a, b);
    max = Math.max(max, c);
    max = Math.max(max, d);

    return max;
  }
}