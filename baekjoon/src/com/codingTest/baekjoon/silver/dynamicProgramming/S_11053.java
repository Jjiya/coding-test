package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_11053 {
  // https://www.acmicpc.net/problem/11053
  public static void test() throws IOException {
    M4.test();
  }

  static class M4 {
//    참고: https://velog.io/@noion0511/PythonKotlin-%EB%B0%B1%EC%A4%80-11053%EB%B2%88-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4
    public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] sequence = new int[n];
    int[] dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;
//      찾아보니 이중 for문 돌려야하네 데이터가 작으면 거의 해답이 O(N^2)인듯
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (sequence[j] < sequence[i]) {
          /*
            순서대로 증가하는지 검증해야한다고 생각했는데
            이미 앞에서 i번째 숫자보다 작은 숫자만 넣어서 개수를 세었음 = 증가하는 순서 보장
            그리고 들어간 값이 어떻든 가장 길이가 긴 것만 찾으면 되니까 max를 통해서
            어떤 수열의 뒤를 이으면 좋을지 정하면 됨 그 부분이 Math.max(dp[i], dp[j] + 1)임
           */
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }

      max = Math.max(max, dp[i]);
    }

//      자기 자신도 수열의 수에 포함
    System.out.print(max + 1);
    }
  }

  static class M3 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      int[] sequence = new int[n];
      int[] dp = new int[n];
      /*
      앞에는 현재 넣은 값
      뒤에는 현재 넣은 개수
       */

      /*
      값을 단순히 대소 비교를 통해 갱신만 하는 것은
      최대 길이의 수열을 보장하지 못한다!!!!

      그럼 현재 값과 그 뒤의 값을 대소 비교를 통해서 넣어야하나?
      그치만 그 뒤의 뒤값이 최소값이라면...?

      그럼 뒤에서부터 큰 값 순으로 넣어야하나....
       */

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        sequence[i] = Integer.parseInt(st.nextToken());
      }

      int lastIdx = n - 1;

      dp[lastIdx] = Math.max(sequence[lastIdx], sequence[--lastIdx]);

      for (int i = lastIdx; i > 0; i--) {
        int bigger = Math.max(sequence[i], sequence[i - 1]);

        // 큰 값이랑 단순 대소 비교를 하는 것도 최대 길이를 보장하지 못함
        if (bigger < dp[lastIdx + 1]) {
          dp[lastIdx--] = bigger;
        }
      }

      if (sequence[0] < dp[lastIdx]) {
        dp[--lastIdx] = sequence[0];
      }

      int count = 0;
      for (int i = n - 1; i >= 0; i--) {
        if (dp[i] == 0) {
          break;
        }
        count++;
      }

      System.out.println(count);
    }
  }

  static class M2 {
    /*
    6
    1 5 2 6 3 4
    답 4
    경우와 같은 경우
    1다음에 바로 5를 넣어버려서 더 많은 경우의 수를 포함하지 못함
    1 -> 5 -> 6
    정답 1 -> 2 -> 3 -> 4
    
    다른 방법을 찾아봐야함
     */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      int[] sequence = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());

      int min = 1001;
      for (int i = 0; i < n; i++) {
        sequence[i] = Integer.parseInt(st.nextToken());

        min = Math.min(min, sequence[i]);
      }

      int minCount = 0;

      for (int num : sequence) {
        if (num == min) {
          minCount++;
        }
      }
      ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<>(minCount);

      for (int i = 0; i < minCount; i++) {
        sequenceList.add(new ArrayList<>());
      }

      int addIdx = 0;

      for (int num : sequence) {
        if (num == min) {
          sequenceList.get(addIdx).add(num);
          addIdx++;
        } else {
          for (ArrayList<Integer> list : sequenceList) {
            if (list.size() == 0) {
              continue;
            }

            if (list.get(list.size() - 1) < num) {
              list.add(num);
            }
          }
        }
      }

      int maxCount = 0;

      for (ArrayList<Integer> list : sequenceList) {
        maxCount = Math.max(maxCount, list.size());
      }

      System.out.println(maxCount);
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      int[] sequence = new int[n];
      int[] dp = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        sequence[i] = Integer.parseInt(st.nextToken());
      }

      if (n == 1) {
        System.out.print(1);
        return;
      }

      dp[0] = 1;
      dp[1] = (sequence[0] < sequence[1]) ? 2 : 1;

      int max = 0;

    /*
    이렇게하면 초반의 증가 수열과 후반의 증가 수열이 이어지질 않음...
     */
      for (int i = 2; i < n; i++) {
        if (sequence[i] > sequence[i - 1]) {
          dp[i] = dp[i - 1] + 1;
        }

        if (sequence[i] > sequence[i - 2]) {
          dp[i] = Math.max(dp[i], dp[i - 2] + 1);
        }

        dp[i] = Math.max(dp[i], 1);

        max = Math.max(max, dp[i]);
      }

      System.out.print(max);
    }
  }
  /* 반례
  https://www.acmicpc.net/board/view/108732
1
1
답 1

4
5 1 2 3
답 3

6
1 5 2 6 3 4
답 4

4
1 4 2 3
답 3

5
1 4 2 3 5
답 4

   */
}
