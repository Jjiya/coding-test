package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.*;

//맨 아래 반례 모아둠
public class S_2606 {
  static HashMap<Integer, ArrayList<Integer>> list;
  static int[][] connect;
  static int[] isVisited;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int node = Integer.parseInt(br.readLine());
    int v = Integer.parseInt(br.readLine());

    connect = new int[node + 1][node + 1];
    isVisited = new int[node + 1];

    StringTokenizer st;
    for (int i = 0; i < v; i++) {
      st = new StringTokenizer(br.readLine());

      int connect_01 = Integer.parseInt(st.nextToken());
      int connect_02 = Integer.parseInt(st.nextToken());

      connect[connect_01][connect_02] = connect[connect_02][connect_01] = 1;
    }

    dfs(1);

    long wormCount = Arrays.stream(isVisited).filter(visit -> visit == 1).count();

    System.out.println(Math.max(wormCount - 1, 0));
  }

  static void dfs(int connectNum) {
    isVisited[connectNum] = 1;

    for (int i = 1; i < connect[connectNum].length; i++) {
      if (connect[connectNum][i] == 1 && isVisited[i] == 0) {
        dfs(i);
      }
    }
  }


  //  틀림 >> 입력값의 시작이 1이 아니면 에러 발생... 9 1 의 경우 1로 시작 안해서 연결 되었다 인식을 안함
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int node = Integer.parseInt(br.readLine());
    int v = Integer.parseInt(br.readLine());

    list = new HashMap<>(node);
    isVisited = new int[node + 1];

    StringTokenizer st;
    for (int i = 0; i < v; i++) {
      st = new StringTokenizer(br.readLine());

      int computerNumber = Integer.parseInt(st.nextToken());
      int connectNumber = Integer.parseInt(st.nextToken());

      ArrayList<Integer> connectList = list.getOrDefault(computerNumber, new ArrayList<>());
      connectList.add(connectNumber);

      list.put(computerNumber, connectList);
    }

    dfsForHashMap(1);

    long wormCount = Arrays.stream(isVisited).filter(visit -> visit == 1).count();

    System.out.println(Math.max(wormCount - 1, 0));
  }

  static void dfsForHashMap(int node) {
    isVisited[node] = 1;

    if (list.containsKey(node)) {
      for (int connect : list.get(node)) {
        if (isVisited[connect] != 1) {
          dfsForHashMap(connect);
        }
      }
    }
  }
}
/*
https://www.acmicpc.net/board/view/87929

풀면서 반례가 꽤 모였길래 푸시는 분들에게 도움이 될까하여 올려놓습니다.
예시 별로 빈 칸으로 띄워놨고 마지막 줄 # 뒤가 정답입니다.

2
1
2 1 # 1

10
7
1 2
2 3
3 4
5 6
7 8
8 9
9 1 # 6

5
3
4 5
1 2
2 3 # 2

4
6
1 2
1 3
1 4
2 3
2 4
3 4 # 3

7
6
2 3
1 2
1 5
5 2
5 6
4 7 # 4

1
0 # 0

10
0 # 0

4
3
1 2
4 3
2 3 # 3
 */
