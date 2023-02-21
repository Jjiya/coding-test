package com.codingTest.baekjoon.silver.implement;

import java.io.*;

public class S_3085 {
  // https://www.acmicpc.net/problem/3085
  static char[][] graph;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    graph = new char[n][n];

    for (int i = 0; i < n; i++) {
      String candyList = br.readLine();
      for (int j = 0; j < n; j++) {
        graph[i][j] = candyList.charAt(j);
      }
    }

    int max = Math.max(1, getSameCandies());

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j + 1 < n) {
          swap(i, j, i, j + 1);
          max = Math.max(max, getSameCandies());
          swap(i, j, i, j + 1);
        }

        if (i + 1 < n) {
          swap(i, j, i + 1, j);
          max = Math.max(max, getSameCandies());
          swap(i, j, i + 1, j);
        }
      }
    }

    System.out.print(max);
  }

  static int getSameCandies() {
    int count = 1;

    for (int i = 0; i < graph.length; i++) {
      int horizon = 1;
      for (int j = 1; j < graph.length; j++) {
        if (graph[i][j] == graph[i][j - 1]) {
          horizon++;
        } else {
          count = Math.max(count, horizon);
          horizon = 1;
        }
      }
      count = Math.max(count, horizon);
    }

    for (int i = 0; i < graph.length; i++) {
      int vertical = 1;
      for (int j = 1; j < graph.length; j++) {
        if (graph[j][i] == graph[j - 1][i]) {
          vertical++;
        } else {
          count = Math.max(count, vertical);
          vertical = 1;
        }
      }
      count = Math.max(count, vertical);
    }

    return count;
  }

  static void swap(int row1, int col1, int row2, int col2) {
    char tmp = graph[row1][col1];
    graph[row1][col1] = graph[row2][col2];
    graph[row2][col2] = tmp;
  }
}

/* 반례 https://www.acmicpc.net/board/view/58247
3
ZCY
ZCP
PYZ

-> 답:2

4
CCCC
YDYD
DYDY
YDYD

-> 답:4

2
CC
YY

-> 답:2

40
YYYYYYYYYCYYYYYYYYYYYYYYYCZZZZZZZYYYYYZC
PYPCYZCPYCZZCCPZYYPZYYYYPPZZPYCCCZYZZZPY
ZPPCYCCPYYZYPPZCZPYCCCZZYYPZZPYPPPPZPCZC
ZCYYZZYCPPPCCYPYYPZZZZCCCCZZCZCYCYZCZZYC
PYZYZZCCZZCCPPYCZPYPPZYZYYYZZPPCCZYYYZCZ
PPPCZZPCCCCCCCCCCCCCCCCCCYCZYYYZCYYCPCPZ
PZYPZYPPYYYZZZPPPZPYZPYZCZZPYZCZZPPCYCCZ
YPPYYYYCCPYPZPCPPPCZCZZYZZZZYYZPZZCCCZYY
YPZCZCPZYYZCCPPPYPPCCPCYZYYYCPPPYCYYCPYC
ZPYZCCZCYZYYCPCCPPYYZPYCCPPCPZCCZCCZYYPY
CPPPCPZZZCYCPYCZYZZPYPZCYYCCZCZZPZYCPZCZ
YZYCYPCPPYPPPPYYYPYPCPCPZZPPCYZCZPZZZZYP
ZCZPYZPPYYYPYPCZYZZYZZPZCZPPPZYCZYPCPYYC
YPZPZYCCYPZZCCPYYCYZYYYYYCZYZZYZZPPYCZCZ
YCZPZCCCCCYCCCCCCCCCCCZYPYZPCZPZZPZZYPYY
YYYYYYYYYYPYYYYYYYYYYYYYYYYYYYYYYYYYYZZP
ZYZCZZCCZPZCZYCPYPCCPYZYCCPPZZCZYCZCYPYP
YYZYPZZYCPCYCZPZYCZPZCCZYCCCZZZYYYZYYPCP
YZZPZYPYCZCPPCZPYCCPYCYZPCCYYZYPCPPPYYPZ
YYZPPZYCZZZYYPYCYZCCYYZPYCCYPZCCZCCCYYZC
CYZZPPCZYZYCCPCYYCPZPPZZPCZZYZZYZZCZYYPC
PPZYZYZPZZZZYPZYYPZPPZPPZCYCPZYZPPYYYYYZ
CZZZYPZYCCYYYPPZYCYPZPCCPCYYYZZYCPYCYCYY
YCZZCZCCYPPYYZYYYPPPZZYYCCCYYZZZYZZZYYCC
YCZPZPPPZPCYYYZZYCPPZYPZYCZZZZZPYYPYCYPC
PCZZZYYZCPCPCZYYYCPYZCCPZCZPYZZPYPZPYZYY
ZZZZPPPPPYZCZCPYYCCCCCCCCCCCYCCCCCCPCCCP
CPYCYZCZCZCYCPCYYCYZCZYYZCCPZZYZPZCPYCCP
YZZYYZZZZPZZCZCYYCZZPYZYCCPCPZYCYCZPYZPZ
YZZZZZZZZZZZZZZZZZZZZZZZCZZZZZZZZZZZZZZZ
YZZPPPPPPPPPPPPPPCPPPPPYYCYCZZZCCPCCYPYZ
YYZCPYPPYZPPYCZPYCZPCPCZZZCYCZYZCPCPZPZZ
CYZPCYYYYYYYYYYYYCYYYYYYYYYYYZYYCYZYPYZC
CPZCCZZZZZZZZZZZZCZZZZZZZZZZYZCCZCPZZCCY
YYZPCPZZCYYYYYCPYCZPYYYPPZZCCZZCPPPPCCPP
YYZZPCCYZCCCYPCYYPZCZZZZZPPYZCCCCCZCPPCY
PYYYYYYYYYYYYYYYYYYYYYYPYCZZPPYZYPPPPYCC
YPZCZPZYPZPPCYCZYCYPCCCZCZZCCZYZYYCYYZCZ
CPPZZPCYYCCCYCCPZPYYZYCYZYZYPYCPPZPCPCYC
ZPCYPYZPPCYYPYZZZPPZZZCCPYCYPCYYCYPPYCZY

답->37

4
CCCP
CCCP
CCCP
CCCP

답->4

3
YCP
CCY
YPC

답->3

6
CCYYCC
YYCCYY
CCYYCC
YYCCYY
CCYYCC
YYCCYY

답->3

5
CPZCC
ZYCPZ
CYYPZ
ZPZCC
CCPYY

답->3
=> 난 이거 2로 나왔음
 */