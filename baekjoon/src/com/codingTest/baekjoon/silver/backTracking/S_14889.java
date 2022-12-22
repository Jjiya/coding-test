package com.codingTest.baekjoon.silver.backTracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_14889 {
  // https://www.acmicpc.net/problem/14889
  static int n;
  static int[][] abilityLevel;
  static boolean[] isBelong;  // start team에 영입되었는지 확인하는 용도 ( false일 시 영입 x = link 팀)
  static int minDiff = Integer.MAX_VALUE;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    abilityLevel = new int[n][n];
    isBelong = new boolean[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        abilityLevel[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 1);

    System.out.println(minDiff);
  }

  static void dfs(int playerNum, int count) {
    if (count == n / 2) {
      int startTeamScore = 0;
      int linkTeamScore = 0;

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (isBelong[i] && isBelong[j]) { // i번 선수와 j번 선수 모두 start 팀에 속할 시 (= 영입 완료 상태일 때)
            startTeamScore += abilityLevel[i][j] + abilityLevel[j][i];
          } else if (!isBelong[i] && !isBelong[j]) { // i번 선수와 j번 선수 모두 start 팀에 속하지 않을 시
            linkTeamScore += abilityLevel[i][j] + abilityLevel[j][i];
          }
        }
      }

      minDiff = Math.min(minDiff, (Math.abs(startTeamScore - linkTeamScore)));

      return;
    }

    isBelong[playerNum] = true;

    for (int i = playerNum + 1; i < n; i++) {
      if (!isBelong[i]) {
        isBelong[i] = true;
        dfs(i, count + 1);
        isBelong[i] = false;
      }
    }

    isBelong[playerNum] = false;
  }

  /* ********** 선수 번호를 일일이 저장해서 구현 함 ********** */
  static String[] belongToTeam;
  static int[] startTeam;
  static int[] linkTeam;

  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    abilityLevel = new int[n][n];
    startTeam = new int[n / 2];
    linkTeam = new int[n / 2];

    belongToTeam = new String[n];
    Arrays.fill(belongToTeam, "-");

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        abilityLevel[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    startTeam[0] = 0;

    bt(0, 1, "start", startTeam);

    System.out.print(minDiff);

  }

  static void bt(int playerNum, int count, String teamName, int[] players) {
    if (count == n / 2) {
      if (teamName.equals("start")) { // start 팀 멤버 꾸렸으면 link 팀 멤버 꾸리기

        startTeam = players.clone();

        for (int i = 0; i < n; i++) {
          if (belongToTeam[i].equals("-")) {
            linkTeam[0] = i;
            bt(i, 1, "link", linkTeam);
            break;
          }
        }
      } else {
        int startTeamAbility = 0;
        int linkTeamAbility = 0;

        for (int i = 0; i < n / 2; i++) {
          for (int j = i + 1; j < n / 2; j++) {
            startTeamAbility += (abilityLevel[startTeam[i]][startTeam[j]] + abilityLevel[startTeam[j]][startTeam[i]]);
            linkTeamAbility += (abilityLevel[players[i]][players[j]] + abilityLevel[players[j]][players[i]]);
          }
        }

        minDiff = Math.min(minDiff, (Math.abs(startTeamAbility - linkTeamAbility)));
      }
      return;
    }

    belongToTeam[playerNum] = teamName;

    for (int i = playerNum + 1; i < n; i++) {
      if (belongToTeam[i].equals("-")) {
        belongToTeam[i] = teamName;
        players[count] = i;

        bt(i, count + 1, teamName, players);

        belongToTeam[i] = "-";
      }
    }

    count--;
    belongToTeam[playerNum] = "-";
  }
}
