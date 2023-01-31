package com.codingTest.baekjoon.gold.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_2437 {
  // https://www.acmicpc.net/problem/2437

//  TODO : 공식부터 다시 찾아볼 것! 도저히 방법이 생각안났음 ㅠㅠ
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    /*
      참고
      - https://plplim.tistory.com/59
      - https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=hongjg3229&logNo=221627349685
      - https://zzang9ha.tistory.com/124
     */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] weight = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        weight[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(weight);

      int sum = 0;

      for (int i = 0; i < n; i++) {
        if (sum + 1 < weight[i]) {
          System.out.print(sum + 1);
          return;
        }

        sum += weight[i];
      }

      System.out.print(sum + 1);
    }
/* 반례
4
2 3 7 8
*/
  }

  static class M1 {
    static boolean[] canWeighing = new boolean[1_000_000_001];
    static int[] weight;
    static boolean[] visited;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      weight = new int[n];
      visited = new boolean[n];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        weight[i] = Integer.parseInt(st.nextToken());
        canWeighing[weight[i]] = true;
      }

      bp(0, 0);

      for (int i = 1; i < canWeighing.length; i++) {
        if (!canWeighing[i]) {
          System.out.print(i);
          return;
        }
      }
    }

    static void bp(int count, int sum) {
      if (count == weight.length) {
        return;
      }

      canWeighing[sum] = true;

      for (int i = 0; i < weight.length; i++) {
        if (visited[i]) continue;
        visited[i] = true;
        bp(count + 1, sum + weight[i]);
        visited[i] = false;
      }
    }
  }
}
