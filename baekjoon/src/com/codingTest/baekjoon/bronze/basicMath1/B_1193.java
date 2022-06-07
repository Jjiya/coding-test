package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class B_1193 {
  public static void test() throws IOException {
    /**
     1
     1 > 1/1

     2   3
     2 > 1/2  2/1

     4   5   6
     3 > 3/1  2/2 1/3

     7   8   9   10
     4 > 1/4  2/3 3/2 4/1

     11  12  13  14  15
     5 > 5/1  4/2 3/3 2/4 1/5
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    int count = 1;

    outer:
    for (int i = 1; i <= x; i++) {
      int small = 1, large = i;
      String sort = i % 2 == 0 ? "asc" : "desc";

      for (int k = 0; k < i; k++) {
        if (count == x) {
          System.out.print(sort.equals("asc") ? small + "/" + large : large + "/" + small);
          break outer;
        }
        small++;
        large--;
        count++;
      }
    }
  }

  public static void test2() throws IOException {
    //굳이 트리 안만들어도 됐네..?

    /**
     0 > 1/1;
     1 > 2/1 1/2;
     2 > 3/1 2/2 1/3;
     3 > 4/1 3/2 2/3 1/4;
     4 > 5/1 4/2 3/3 2/4 1/5;
     5 > 6/1 5/2 4/3 3/4 2/5 1/6;
     */

    Graph graph = new Graph();
    graph.makeGraph(5);

    System.out.println(graph);
  }

  static class Graph {
    LinkedList<ArrayList<String>> linkedList;

    public Graph() {
      linkedList = new LinkedList();
    }

    void makeGraph(int depth) {
      for (int i = 1; i <= depth; i++) {
        ArrayList<String> arrayList = new ArrayList<>(i);
        int copyI = i;
        for (int j = 1; j < i + 1; j++) {
          arrayList.add(copyI-- + "/" + j);
        }
        linkedList.add(arrayList);
      }
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (ArrayList<String> list : linkedList) {
        sb.append(list.toString()).append("\n");
      }
      return sb.toString();
    }
  }
}
