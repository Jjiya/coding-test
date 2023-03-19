package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class S_10825 {
  // https://www.acmicpc.net/problem/10825
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;
    PriorityQueue<StudentGrade> sortingGrade = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      int korean = Integer.parseInt(st.nextToken());
      int english = Integer.parseInt(st.nextToken());
      int math = Integer.parseInt(st.nextToken());

      StudentGrade studentGrade = new StudentGrade(name, korean, english, math);
      sortingGrade.offer(studentGrade);
    }

    StringBuilder sb = new StringBuilder();

    while (!sortingGrade.isEmpty()) {
      sb.append(sortingGrade.poll().name).append("\n");
    }

    System.out.print(sb);
  }

  static class StudentGrade implements Comparable<StudentGrade> {
    String name;
    int korean;
    int english;
    int math;

    public StudentGrade(String name, int korean, int english, int math) {
      this.name = name;
      this.korean = korean;
      this.english = english;
      this.math = math;
    }

    @Override
    public int compareTo(StudentGrade otherStudent) {
      return compareKoreanScore(otherStudent);
    }

    int compareKoreanScore(StudentGrade otherStudent) {
      if (this.korean == otherStudent.korean) {
        return compareEnglishScore(otherStudent);
      } else {
        return otherStudent.korean - this.korean;
      }
    }

    int compareEnglishScore(StudentGrade otherStudent) {
      if (this.english == otherStudent.english) {
        return compareMathScore(otherStudent);
      } else {
        return this.english - otherStudent.english;
      }
    }

    int compareMathScore(StudentGrade otherStudent) {
      if (this.math == otherStudent.math) {
        return this.name.compareTo(otherStudent.name);
      } else {
        return otherStudent.math - this.math;
      }
    }
  }
}