package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class S_11004 {
  // https://www.acmicpc.net/problem/11004
//  TODO 다시 풀어보기
  public static void test() throws IOException {
    M4.test();
  }

  /* 반례
5 2
4 1 2 3 5
2

5 3
0 1 0 0 0
0

10 9
10 3 9 8 8 8 8 3 2 4
9

1 1
-15
-15

  */
  static class M4 {
    //    https://www.daleseo.com/sort-quick/
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      sort(a, 0, n - 1);

      System.out.print(a[k - 1]);
    }

    static void sort(int[] a, int start, int end) {
      if (start >= end) return;

      int mid = partition(a, start, end);

      sort(a, start, mid - 1);
      sort(a, mid, end);
    }

    static int partition(int[] a, int start, int end) {
      int pivot = a[(start + end) / 2];

      while (start <= end) {
        while (a[start] < pivot) start++;
        while (a[end] > pivot) end--;

        if (start <= end) {
          swap(a, start, end);
          start++;
          end--;
        }
      }

      return start;
    }

    static void swap(int[] a, int i, int j) {
      int tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
  }

  static class M3 {
    //   quick selection sort로 풀어야한다네...
//    메모리 초과
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      ArrayList<Integer> a = new ArrayList<>(n);

      for (int i = 0; i < n; i++) {
        a.add(Integer.parseInt(st.nextToken()));
      }

      System.out.print(quickSelect(a, k));
    }

    //    참고: https://www.youtube.com/watch?v=ymgm5ER6OuQ&list=PLsMufJgu5932XYejsOwcUDJ2F75f56nrl&index=9
    static int quickSelect(ArrayList<Integer> list, int k) {
//      1. pivot p를 고른다.
//      2. p보다 작으면 리스트 a, 같으면 리스트 m, 크면 리스트 b에 넣는다.
//      3-1. a의 길이가 k(현재 리스트에서 k번째로 작은 수)보다 크면 a에 대하여 함수 재 호출
//      3-2. a와 m의 길이가 k보다 작으면 b에 대해 함수 재 호출
//           여기서 k의 값은 k-a.size()-m.size()로 변경한다.
//      3-3. 아니라면 p 값을 반환한다.  (k번째 수는 m리스트에 있다는 의미인데, m에는 p와 동일한 값만 들어있으므로)
      int pivot = list.get(0);

      ArrayList<Integer> a = new ArrayList<>();
      ArrayList<Integer> m = new ArrayList<>();
      ArrayList<Integer> b = new ArrayList<>();

      for (int number : list) {
        if (number == pivot) {
          m.add(number);
        } else if (number < pivot) {
          a.add(number);
        } else {
          b.add(number);
        }
      }

      if (a.size() >= k) {
        return quickSelect(a, k);
      } else if (a.size() + m.size() < k) {
        return quickSelect(b, k - (a.size() + m.size()));
      } else {
        return pivot;
      }
    }
  }

  static class M2 {
    //   시간 초과
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      int[] copyA = Arrays.copyOfRange(a, 0, k);
      Arrays.sort(copyA);

      System.out.println(copyA[k - 1]);
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(a);

      System.out.print(a[k - 1]);
    }
  }
}
