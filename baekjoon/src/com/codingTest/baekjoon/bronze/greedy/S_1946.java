package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1946 {
  // https://www.acmicpc.net/problem/1946

  //  참고: https://www.acmicpc.net/source/39455094
  //  아래와 같은 방법으로 수행 시 사원을 입력 받을 때부터 순위를 정해서 입력을 넣기 떄문에 중간에 정렬을 따로 할 필요가 없음!!
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int[] list;
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      list = new int[n + 1];

      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());

        list[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
      }

      int maxGrade = list[1], count = 1;  // count에 1위 포함
      for (int j = 2; j <= n; j++) {
        if (list[j] < maxGrade) {
          count++;
          maxGrade = list[j];
        }
      }

      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }

  public static void test1() throws IOException {
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

        ==> 최대 지원자 수는 10만 명이기 때문에 2중 for문 돌리면 시간 초과 발생
        한 개의 항목(A)에 대해 오름차순으로 정렬 후 다른 항목(B)에 대해 순위를 비교하여야 한다.
        A B
        1 4
        2 2
        3 3
        4 1
        와 같은 경우 A에 대해 오름차순으로 정렬하였고,
        이후 1위부터 B에 대한 최소값을 측정하며, 해당 최소 값보다 작은 경우에만 신입 사원으로 선발한다.
        3 3 사원의 경우 B에 대한 순위가 앞의 2 2 사원보다 낮기 때문에 선발될 수 없다.

        이렇게 정의가 가능한 이유는 A에 대해 이미 순위별로 정렬을 했기 때문이다.
        앞의 사원들은 정렬된 A에 대해서는 무조건 뒤의 사원들 보다 높은 점수를 가졌음을 보장할 수 있기 때문...

      원*/