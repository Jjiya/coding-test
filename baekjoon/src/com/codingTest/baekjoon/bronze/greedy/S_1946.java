package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1946 {
  // https://www.acmicpc.net/problem/1946
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int[][] list;
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      list = new int[n][2];

      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());

        list[j][0] = Integer.parseInt(st.nextToken());
        list[j][1] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(list, (p1, p2) -> {
        if (p1[0] > p2[0]) {
          return 1;
        } else if (p1[0] < p2[0]) {
          return -1;
        }

        return 0;
      });

      int selectionCount = 1;
      int maxGrade = list[0][1];

      for (int j = 1; j < n; j++) {
        if (list[j][1] < maxGrade) {
          maxGrade = list[j][1];
          selectionCount++;
        }
      }

      sb.append(selectionCount).append("\n");
    }

    System.out.print(sb);
  }
}
/*
1
5
1 1
2 3
3 2
4 4
5 5
=> 1

1
5
1 3
2 2
3 4
4 5
5 1
=> 3

1
7
1 4
2 3
3 2
4 1
5 7
6 6
7 5
=> 4

1
6
6 4
4 1
5 2
1 6
2 3
3 5
=> 3

1
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1
=> 3

1
4
1 4
2 2
3 3
4 1
=> 3
 */

/*
        1. 종목의 점수가 1등이거나
        2. 각 종목의 1등을 가지고 있는 사람의 1등이 아닌 점수보다 등수가 높거나
          각 항목(a와 b로 칭함)의 1등 보유자
            a,b   a,b
        ex) 1,4 / 6,1
        => b의 점수가 3등 이상이며, a의 점수가 5등 이상이어야 한다.

        ==> 모든 지원자 중에서도 1개 이상은 우수해야하므로 위의 가정은 틀렸음...
        참고: https://www.acmicpc.net/board/view/2488
        1
        4
        1 4
        2 2
        3 3
        4 1
        => 이 경우에 3 3 지원자는 다른 2 2 지원자보다 더 높은 성적이 없으므로 제외, 3명이 답이어야 한다고 함

        그럼 1등을 보유한 지원자를 제외하고는, 모든 지원자를 순회하며 뛰어난게 있으면 뽑아야겠네...
       */