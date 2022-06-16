package com.codingTest.baekjoon.silver.recursive;

import java.io.*;

public class S_17478 {
//  재귀함수
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int depth = Integer.parseInt(br.readLine());
    System.out.print(questionRecursive(depth, 0));
  }

  //  무식하게 for문 돌리기
  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(recursiveQuestion(Integer.parseInt(br.readLine())));
  }

  static String questionRecursive(int depth, int index) {
    String depthUnderBar = "____".repeat(index);
    String answer = depthUnderBar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    String repeat =
        depthUnderBar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
            depthUnderBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
            depthUnderBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";

    return (index == 0 ? "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n" : "") +
        depthUnderBar + "\"재귀함수가 뭔가요?\"\n" +
        ((index == depth) ? answer : repeat + questionRecursive(depth, index + 1)) +
        depthUnderBar + "라고 답변하였지.\n";
  }


  static String recursiveQuestion(int depth) {
    StringBuilder sb = new StringBuilder();
    sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    for (int i = 0; i < depth; i++) {
      sb.append(repeat(i));
      if (i == depth - 1)
        sb.append("____".repeat(i + 1)).append("\"재귀함수가 뭔가요?\"\n").append("____".repeat(i + 1)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
    }
    for (int j = depth; 0 <= j; j--) {
      sb.append(answer(j));
    }

    return sb.toString();
  }

  static String repeat(int depth) {
    return "____".repeat(depth) + "\"재귀함수가 뭔가요?\"\n" +
        "____".repeat(depth) + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
        "____".repeat(depth) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
        "____".repeat(depth) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
  }

  static String answer(int depth) {
    return "____".repeat(depth) + "라고 답변하였지.\n";
  }
}
