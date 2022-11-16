package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 아래에 반례 모아둠
public class S_2667 {
  //                               동       남       서       북
  static int[][] mapDirection = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  static int[][] map;
  static boolean[][] isVisited;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    isVisited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        map[i][j] = Character.getNumericValue(line.charAt(j));
      }
    }
    int housingAreaNum = 0;

    ArrayList<Integer> count = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (!isVisited[i][j]) {
          int areaCount = bfs(i, j);

          if (areaCount != 0) {
            count.add(areaCount);
            housingAreaNum--;
          }
        }
      }
    }

    System.out.println(housingAreaNum * -1);
    count.stream().sorted().forEach(System.out::println);
  }

  static int bfs(int x, int y) {
    if (map[x][y] == 0) {
      return 0;
    }

    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[]{x, y});

    isVisited[x][y] = true;
    int areaCount = 1;

    while (!queue.isEmpty()) {
      int[] currentXy = queue.poll();

      for (int[] direction : mapDirection) {
        int nextX = currentXy[0] + direction[0];
        int nextY = currentXy[1] + direction[1];

        if (0 <= nextX && 0 <= nextY && nextX < map.length && nextY < map.length) {
          if (0 < map[nextX][nextY] && !isVisited[nextX][nextY]) {
            isVisited[nextX][nextY] = true;
            queue.offer(new int[]{nextX, nextY});

            areaCount++;
          }
        }
      }
    }

    return areaCount;
  }
}

/*
반례 모음: https://www.acmicpc.net/board/view/97339

7
1110101
0110101
1110101
0000111
0100000
0111110
0111001

4
1
8
9
9

7
1110011
1110011
1110011
0000011
0000000
0111100
0111000

3
7
8
9

<< 정답 틀림>>
3
101
010
101

5
1
1
1
1
1

------내가 출력한 답------
4
1
1
1
2
------------

3
101
101
111

1
7

5
11111
11111
00000
11100
00000

2
3
10

5
11000
00000
00111
00000
10000

3
1
2
3

5
11111
11111
11111
11111
11111

1
25

5
11010
10110
11010
01110
00000

1
12

5
00000
00000
00000
00000
00000

0

6
000100
100001
101101
101111
111000
000000

2
1
14

8
00000100
10000101
10110101
10111101
11100001
00111111
00000000
00000000

1
25

5
11100
11100
00000
00001
00000

2
1
6

5
10101
01111
11111
01011
10111

3
1
1
17

25
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110
1100110011001100110011000
0011001100110011001100110

144
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
2
4
4
4
4
4
4
 */