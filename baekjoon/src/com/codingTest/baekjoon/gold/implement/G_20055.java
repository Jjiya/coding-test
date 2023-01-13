package com.codingTest.baekjoon.gold.implement;

import java.io.*;
import java.util.*;

/*
  [오해 1]
    https://www.acmicpc.net/board/view/102450
    컨베이어 벨트가 회전할 때 벨트의 번호가 변하는 줄 몰랐음
 */
public class G_20055 {
  // https://www.acmicpc.net/problem/20055
  static int[] durabilityList;
  static boolean[] hasRobot;
  static int putIdx;
  static int removeIdx;
  static int beltLength;
  static int zeroDurabilityCount = 0;
  /*
    참고: https://yabmoons.tistory.com/599
    로봇 움직이는 부분에서 틀렸던 것 같은데... 먼저 올린 로봇부터 움직인다에서 오류가 난듯!! queue로 해결된듯하다..
   */
  static Queue<Integer> putList;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    beltLength = n * 2;
    putList = new LinkedList<>();
    int k = Integer.parseInt(st.nextToken());

    durabilityList = new int[beltLength];
    hasRobot = new boolean[beltLength];
    putIdx = 0;
    removeIdx = n - 1;

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < beltLength; i++) {
      durabilityList[i] = Integer.parseInt(st.nextToken());
    }

    int level = 0;

    while (zeroDurabilityCount < k) {
      movingBelt();
      movingRobot();
      putRobot();

      level++;
    }

    System.out.print(level);
  }

  static void movingBelt() {
    setPutIdx();
    setRemoveIdx();

    removeRobot();
  }

  static void movingRobot() {
    Queue<Integer> subPutList = new LinkedList<>();

    while (!putList.isEmpty()) {
      Integer current = putList.poll();

      if (!hasRobot[current]) continue;
      if (current == removeIdx) {
        removeRobot();
        continue;
      }

      int next = (current + 1) % beltLength;

      if (!validSpace(next)) {
        subPutList.add(current);
        continue;
      }

      hasRobot[current] = false;
      hasRobot[next] = true;

      if (--durabilityList[next] <= 0) {
        zeroDurabilityCount++;
      }

      if (next == removeIdx) {
        removeRobot();
      } else {
        subPutList.add(next);
      }
    }

    putList = subPutList;
  }

  /*
    https://www.acmicpc.net/source/36184530
    다른 사람들은 출구-1 ~ 출구까지 탐색해서 잘 풀었네...
  */
  static void movingRobot2() {
    int findIdx = putIdx - 1;

    if (findIdx < 0) {
      findIdx = beltLength - 1;
    }
    int count = 0;

    while (count++ != beltLength) {
      if (!hasRobot[findIdx]) {
        if (--findIdx < 0) {
          findIdx = beltLength - 1;
        }
        continue;
      }

      int nextIdx = (findIdx + 1) % beltLength;

      if (!validSpace(nextIdx)) continue;

      hasRobot[findIdx] = false;
      hasRobot[nextIdx] = true;
      durabilityList[nextIdx]--;

      if (durabilityList[nextIdx] == 0) {
        zeroDurabilityCount++;
      }

      if (--findIdx < 0) {
        findIdx = beltLength - 1;
      }
    }

    removeRobot();
  }

  static void removeRobot() {
    hasRobot[removeIdx] = false;
  }

  static void putRobot() {
    if (validSpace(putIdx)) {
      hasRobot[putIdx] = true;
      durabilityList[putIdx]--;

      putList.add(putIdx);

      if (durabilityList[putIdx] == 0) {
        zeroDurabilityCount++;
      }
    }
  }

  static boolean validSpace(int idx) {
    return !hasRobot[idx] && 0 < durabilityList[idx];
  }

  static void setPutIdx() {
    putIdx--;
    if (putIdx < 0) putIdx = beltLength - 1;
  }

  static void setRemoveIdx() {
    removeIdx--;
    if (removeIdx < 0) removeIdx = beltLength - 1;
  }

  static void print() {
    System.out.println("--------------------");
    StringBuilder topSb = new StringBuilder();
    StringBuilder middleSb = new StringBuilder();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < beltLength; i++) {
      if (i == putIdx) {
        topSb.append(" [ p ]  ");
      } else if (i == removeIdx) {
        topSb.append(" [ r ]  ");
      } else {
        topSb.append("        ");
      }

      middleSb.append(hasRobot[i] ? " [    ] " : "  ____  ");
      sb.append(" [ ").append(String.format("%02d", durabilityList[i])).append(" ] ");
    }

    System.out.println(topSb);
    System.out.println(middleSb);
    System.out.println(sb);
  }

  /*
  // https://www.acmicpc.net/problem/12100
  static int beltLength;
  static int n;
  static int level = 0;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    beltLength = n * 2;

    st = new StringTokenizer(br.readLine());
    Belt belt = new Belt();

    for (int i = 0; i < beltLength; i++) {
      belt.addSpace(new Space(i, Integer.parseInt(st.nextToken())));
    }

    while (belt.zeroDurabilityCount < k) {
      belt.working();
      level++;
    }

    System.out.print(level);
  }

  static class Belt {
    LinkedList<Space> belt = new LinkedList<>();
    Space puttingZone;
    int lastBeltIdx;
    int zeroDurabilityCount = 0;

    void addSpace(Space space) {
      belt.add(space);
      setPuttingZone(space);
      setLastBelt(space, beltLength - 1);
    }

    void setPuttingZone(Space space) {
      if (space.idx == 0) {
        puttingZone = space;
      }
    }

    void setLastBelt(Space space, int idx) {
      if (space.idx == beltLength - 1) {
        lastBeltIdx = idx;
      }
    }

    void working() {
      movingBelt();
      movingRobot();
      putRobot();
      updateZeroDurabilityCount();
    }

    void movingBelt() {
      for (int i = 0; i < beltLength; i++) {
        Space space = belt.get(i);

        space.movingNext();

        if (space.idx == n - 1) {
          space.deleteRobot();
        }

        setLastBelt(space, i);

        setPuttingZone(space);
      }
    }

    void movingRobot() {
      int count = 0;
      int findIdx = lastBeltIdx;  // 마지막 번호 벨트에서 앞으로 탐색

      while (count++ < beltLength) {
        Space current = belt.get(findIdx);
        Space nextSpace = belt.get((findIdx + 1) % beltLength);

        if (current.hasRobot && nextSpace.idValidSpace()) {
          current.deleteRobot();
          nextSpace.addRobot();
        }

        if (--findIdx < 0) findIdx = beltLength - 1;
      }
    }

    void putRobot() {
      puttingZone.addRobot();
    }

//    void print() {
//      StringBuilder topSb = new StringBuilder();
//      StringBuilder sb = new StringBuilder();
//      System.out.println("====Belt====");
//
//      for (Space space : belt) {
//        topSb.append(String.format("%05d, ", space.idx));
//        sb.append(space.hasRobot ? String.format("[%03d], ", space.durability) : String.format("_%03d_, ", space.durability));
//      }
//
//      System.out.println(topSb);
//      System.out.println(sb);
//      System.out.println();
//    }

    void updateZeroDurabilityCount() {
      zeroDurabilityCount = 0;
      for (Space space : belt) {
        if (space.durability == 0) zeroDurabilityCount++;
      }
    }
  }

  static class Space {
    int idx;
    int durability;
    boolean hasRobot;

    public Space(int idx, int durability) {
      this.idx = idx;
      this.durability = durability;
      this.hasRobot = false;
    }

    void addRobot() {
      if (this.durability == 0) {
        return;
      }

      --this.durability;

      if (this.idx == n - 1) {
        deleteRobot();
      } else {
        this.hasRobot = true;
      }
    }

    void deleteRobot() {
      this.hasRobot = false;
    }

    void movingNext() {
      this.idx = (this.idx + 1) % beltLength;
    }

    boolean idValidSpace() {
      return this.durability != 0 && !this.hasRobot;
    }
  }
   */
}
