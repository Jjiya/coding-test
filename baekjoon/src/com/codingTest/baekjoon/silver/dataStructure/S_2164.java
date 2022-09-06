package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S_2164 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> card = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      card.add(i);
    }

    while (card.size() != 1) {
      card.poll();
      card.offer(card.poll());
    }

    System.out.print(card.poll());
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> card = new Stack<>();

    for (int i = n; i > 0; i--) {
      card.add(i);
    }

    while (card.size() != 1) {
      card.pop();
      card.add(0, card.pop());
    }

    System.out.print(card.pop());
  }
}

/*
1 2 3 4 5 6
2 3 4 5 6
3 4 5 6 2

3 4 5 6 2
4 5 6 2
5 6 2 4

5 6 2 4
6 2 4
2 4 6

2 4 6
4 6
6 4

6 4
4


1 2 3 4
2 3 4
3 4 2

3 4 2
4 2
2 4

2 4
4

//

1개일땐 = 1  0
1

2개일땐 = 2  1
0
1 2

3개일땐 = 2  1
0
1 2 3

4개일땐 = 4  3
1
1 2 3 4
2 4

5개일땐 = 2  1
1
1 2 3 4 5
2 4

6개일땐 = 4  3
1
1 2 3 4 5 6
2 4 6

7개일땐 = 6  5
2
1 2 3 4 5 6 7
2 4 6

8개일땐 = 8
3
1 2 3 4 5 6 7 8
2 4 6 8

9개일땐 = 8
3
1 2 3 4 5 6 7 8 9

10개일땐 = 4
1
1 2 3 4 5 6 7 8 9 10




*/

