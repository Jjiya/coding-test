package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S_1966 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testcase = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < testcase; i++) {
      PrintList printList = new PrintList();

      st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());


      st = new StringTokenizer(br.readLine());

//       save print list
      for (int j = 0; j < n; j++) {
        Print print = new Print(Integer.parseInt(st.nextToken()), j == m);
        printList.addPrint(print);
      }

//      output by priority
      int printSequence = 1;

      while (printList.count != 0) {
        int maxPriority = printList.maxPriority();  // 우선 순위 높은 값
        Print peekFront = printList.getFrontPrint();  // 현재 앞에 있는 프린트

        if (maxPriority == peekFront.getPriority()) {
          if (peekFront.isSaveIdx) {  // m에 해당하는 프린트일 시 반복문 종료
            sb.append(printSequence).append("\n");
            break;
          } else {  // m에 해당하는 프린트가 아닐 시 출력 및 count 증가
            printList.output();
            printSequence++;
          }
        } else {  // 우선 순위 높은 프린트 존재 시 뒤로 보냄
          printList.moveBack(peekFront);
        }
      } //end while
    }// end for

    System.out.print(sb);
  }

  static class PrintList {
    LinkedList<Print> printList;
    int count = 0;

    PrintList() {
      printList = new LinkedList<>();
    }

    void addPrint(Print print) {
      if (count != 0) {
        this.getLastPrint().setNextPrint(print);
      }

      printList.add(print);
      count++;
    }

    Print getLastPrint() {
      return printList.get(count - 1);
    }

    Print getFrontPrint() {
      return printList.get(0);
    }

    int maxPriority() {
      int maxPriority = 0;

      for (Print print : printList) {
        maxPriority = Math.max(maxPriority, print.getPriority());
      }

      return maxPriority;
    }

    void moveBack(Print movedPrint) {
      removePrint(0);

      movedPrint.setNextPrint(null);

      getLastPrint().setNextPrint(movedPrint);

      addPrint(movedPrint);
    }

    Print output() {
      Print outputPrint = printList.get(0);
      removePrint(0);

      return outputPrint;
    }

    void removePrint(int index) {
      printList.remove(index);

      count--;
    }
  }

  static class Print {
    int priority;
    boolean isSaveIdx;
    Print nextPrint;

    Print(int priority, boolean isSaveIdx) {
      this.priority = priority;
      this.isSaveIdx = isSaveIdx;
    }

    public void setNextPrint(Print nextPrint) {
      this.nextPrint = nextPrint;
    }

    public int getPriority() {
      return priority;
    }
  }
}
