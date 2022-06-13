package com.codingTest.baekjoon.gahuiTest;

import java.io.*;
import java.util.StringTokenizer;

public class B {
  public static class Monster {
    private int[] clock;
    private int hour;
    private int minute;
    private int timeArea;

    public Monster(int[] clock, int hour, int minute) {
      this.clock = clock;
      this.hour = hour;
      this.minute = minute;
      changeArea(hour);
    }

    void changeArea(int hour) {
      if (hour == 12 || hour == 1) this.timeArea = 0;
      else if (hour == 2 || hour == 3) this.timeArea = 1;
      else if (hour == 4 || hour == 5) this.timeArea = 2;
      else if (hour == 6 || hour == 7) this.timeArea = 3;
      else if (hour == 8 || hour == 9) this.timeArea = 4;
      else if (hour == 10 || hour == 11) this.timeArea = 5;
    }

    boolean checkAllLock() {
      for (int i = 0; i < this.clock.length; i++) {
        if (this.clock[i] != 0) return false;
      }
      return true;
    }

    int hpUp() {
      int sum = 0;
      for (int i = 0; i < this.clock.length; i++) {
        sum += this.clock[i];
      }
      return sum;
    }

    public int[] getClock() {
      return clock;
    }

    public void setClock(int[] clock) {
      this.clock = clock;
    }

    public int getHour() {
      return hour;
    }

    public void setHour(int hour) {
      this.hour = hour;
    }

    public int getMinute() {
      return minute;
    }

    public void setMinute(int minute) {
      this.minute = minute;
    }

    public int getTimeArea() {
      return timeArea;
    }

    public void setTimeArea(int timeArea) {
      this.timeArea = timeArea;
    }
  }

  public static class User {
    private Monster monster;
    private double playTime;

    public User(Monster monster) {
      this.monster = monster;
      this.playTime = 0.0;
    }

    String attack(String[] actions) {
      this.playTime += Double.parseDouble(actions[0]);

      String action = actions[1];
      if (action.equals("^")) {
        int[] mClock = this.monster.getClock();
        mClock[this.monster.getTimeArea()] = 0;
        this.monster.setClock(mClock);
      } else if (0 < action.indexOf("HOUR")) {
        int changeHour = Integer.parseInt(action.split("HOUR")[0]) + this.monster.getHour();
        if (12 < changeHour) changeHour -= 12;
        this.monster.setHour(changeHour);
        this.monster.changeArea(changeHour);
      } else if (0 < action.indexOf("MIN")) {
        int changeMin = Integer.parseInt(action.split("MIN")[0]) + this.monster.getMinute();
        if (60 < changeMin) {
          changeMin -= 60;
          this.monster.setHour(this.monster.getHour() + 1);
        }
        this.monster.setMinute(changeMin);
        this.monster.changeArea(this.monster.getHour());
      }

      if (this.monster.checkAllLock()) return "end";
      else return "ing";
    }

    public Monster getMonster() {
      return monster;
    }

    public void setMonster(Monster monster) {
      this.monster = monster;
    }

    public double getPlayTime() {
      return playTime;
    }

    public void setPlayTime(double playTime) {
      this.playTime = playTime;
    }
  }

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] monsterTime = br.readLine().split(":");

    int[] monsterClock = new int[6];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 6; i++) {
      monsterClock[i] = Integer.parseInt(st.nextToken());
    }

    Monster papulatus = new Monster(monsterClock, Integer.parseInt(monsterTime[0]), Integer.parseInt(monsterTime[1]));
    User user = new User(papulatus);

    int l = Integer.parseInt(br.readLine());

    boolean finish = false;
    for (int i = 0; i < l; i++) {
      String attackResult = user.attack(br.readLine().split("\\s"));
      if (attackResult.equals("end")) {
        finish = true;
        break;
      }
    }

    System.out.print(finish ? 0 : papulatus.hpUp());
  }
}
