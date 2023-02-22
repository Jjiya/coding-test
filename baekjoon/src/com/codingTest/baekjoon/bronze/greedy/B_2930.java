package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_2930 {
  // https://www.acmicpc.net/problem/2930
  /*
    처음에 이해를 못했던 것이 " 상근이가 친구들이 무엇을 낼지 미리 알고있었다고 가정할 때, 상근이가 얻을 수 있는 최고 점수를 구하는 프로그램을 작성하시오. " 이 부분임
    "훈련은 친구 N명과 동시에 한다. ... 각 라운드의 점수 계산은 상근이와 친구 개개인을 독립적으로 비교한다. " 이 부분도 같이 이해를 못했던 탓

    최고 점수를 매기는 법
    가위바위보를 진행 시 i회차에 R, S, P 를 냈다고 가정 시
    N명의 친구들이 i번째 낸 값과 비교해서 점수를 매긴다.
    만약 친구가 낸 목록이 아래와 같을 때 
    PPRRS
    RRSSP
    
    i=0 회차에서 R을 냈다면 총 1점, S를 냈다면 총 2점, P를 냈다면 총 3점을 얻을 수 있다.
    i=1 회차에서 R을 냈다면 총 1점, S를 냈다면 총 2점, P를 냈다면 총 3점을 얻을 수 있다.
    총 r번째 라운드까지 진행 시 i번째 라운드 별 최고 값을 합산하면 상근이가 얻을 수 있는 최고의 점수이다.
    
    결국 각 라운드에서 고정된 값(묵찌빠)을 내야하는데, 뭘 내야지 가장 높은 점수를 얻을 수 있냐는 말이다.....  
   */
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int r = Integer.parseInt(br.readLine());

    char[] sangGeun = br.readLine().toCharArray();

    int n = Integer.parseInt(br.readLine());
    char[][] friendList = new char[n][r];

    for (int i = 0; i < n; i++) {
      friendList[i] = br.readLine().toCharArray();
    }

    int originScore = 0;
    int maxScore = 0;
    char[] shapeList = {'R', 'S', 'P'};

    for (int i = 0; i < r; i++) {
      int[] shapeScore = new int[3];

      for (int j = 0; j < n; j++) {
        char friend = friendList[j][i];

        originScore += playing(sangGeun[i], friend);

        for (int k = 0; k < 3; k++) {
          shapeScore[k] += playing(shapeList[k], friend);
        }
      }

      maxScore += Math.max(shapeScore[0], Math.max(shapeScore[1], shapeScore[2]));
    }

    System.out.println(originScore);
    System.out.print(maxScore);
  }

  static int playing(char sangguen, char friend) {
    int result = getValue(sangguen) - getValue(friend);

    if (result == 0) {  // 비김
      return 1;
    }

    if (result == -1 || result == 2) {  // 이김
      return 2;
    }

    return 0; // 짐
  }

  static int getValue(char shape) {
    if (shape == 'R') {
      return 0;
    } else if (shape == 'S') {
      return 1;
    } else {
      return 2;
    }
  }
}
