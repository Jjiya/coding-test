package com.codingTest.baekjoon.gold.greedy;

import java.io.*;
import java.util.*;

public class G_1202 {
  // https://www.acmicpc.net/problem/1202
  public static void test() throws IOException {
    M3.test();
  }

  static class Jewelry {
    int weight;
    int price;

    public Jewelry(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }
  }

  static class M3 {
    /* M2 방법에서 해결 못한 이유

      while (!bag.isEmpty()) {
      }

      이 부분에서 보면 subQueue를 만들어서 지금 가방보다 무게가 큰 애들은 따로 저장해서 다시 pq에 넣어준다.
      다른 풀이를 보면 애초에 보석을 무게 순으로 오름차순 정렬을 해놔서 이미 탐색이 끝나서 pq에 넣은 보석은
      다음 탐색에 있을 가방에 넣을 수 있음을 보장하게 된다.
      
      가방 오름차순
      5 9 10
      보석 무게 오름차순
      1 3 4 10 20
      9 4 7 60 2
      
      가방 5 탐색 시
      1. 보석을 idx번째부터 탐색을 시작한다.
      2. 현재 가방 무게보다 작은 보석을 가격 순으로 내림차순 정렬하는 pq에 넣는다.
      3. 탐색이 끝나면 pq에서 값을 꺼낸다
        -> 가격 순 내림차순 && 현재 가방의 무게보다 작거나 같은 보석
        = 꺼낸 보석은 무조건 최대로 큰 경우의 수임
      4. 가방의 개수만큼 1~3을 실행한다.
        -> 1번 수행시 idx는 이전에 탐색을 멈춘 인덱스부터 탐색을 시작한다.
           이미 idx앞의 보석들은 pq에 넣었으므로 재탐색할 필요가 없게된다.
        -> 이때 pq에 있는 보석들은 앞의 가방의 무게보다 작거나 같으므로
           현재 탐색하는 가방의 무게보다 무조건 작거나 같음을 보장하는 것이다.
      
    */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken()); // 보석 개수
      int k = Integer.parseInt(st.nextToken()); // 가방 개수

      PriorityQueue<Jewelry> jewelryList = new PriorityQueue<>(
          (j1, j2) -> j1.weight == j2.weight ? j2.price - j1.price : j1.weight - j2.weight
      );  // 가방 무게 순 오름차순 (무게 동일 시 가격 내림차순)

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());

        jewelryList.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      long price = 0L;

      PriorityQueue<Integer> bag = new PriorityQueue<>();

      for (int i = 0; i < k; i++) {
        bag.offer(Integer.parseInt(br.readLine()));
      }

      PriorityQueue<Integer> heavyJewelryDesc = new PriorityQueue<>(Comparator.reverseOrder());  // 가격 정보만 저장 + 가격 기준 내림차순 정렬

      while (!bag.isEmpty()) {
        Integer currentBag = bag.poll();

        while (!jewelryList.isEmpty()) {
          if (jewelryList.peek().weight <= currentBag) {
            heavyJewelryDesc.offer(jewelryList.poll().price);
          } else {
            break;
          }
        }

        if (heavyJewelryDesc.isEmpty()) continue;

        price += heavyJewelryDesc.poll();
      }

      System.out.print(price);
    }
  }

  static class M2 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken()); // 보석 개수
      int k = Integer.parseInt(st.nextToken()); // 가방 개수

      PriorityQueue<Jewelry> jewelryList = new PriorityQueue<>((j1, j2) -> j2.price - j1.price);  // 가격 기준 내림차순 정렬

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());

        jewelryList.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      long price = 0L;

      PriorityQueue<Integer> bag = new PriorityQueue<>();

      for (int i = 0; i < k; i++) {
        bag.offer(Integer.parseInt(br.readLine()));
      }

      Queue<Jewelry> subList = new LinkedList<>();

      while (!bag.isEmpty()) {
        Integer currentBag = bag.poll();

        while (!jewelryList.isEmpty()) {
          Jewelry currentJewelry = jewelryList.poll();

          if (currentJewelry.weight <= currentBag) {
            price += currentJewelry.price;
            break;
          } else {
            subList.offer(currentJewelry);
          }
        }

        while (!subList.isEmpty()) {  // 뒤에 있는 가방에는 지금 못넣은 보석들을 넣을 기회가 있을 수 있어서...
          jewelryList.offer(subList.poll());
        }
      }

      System.out.print(price);
    }
  }

  static class M1 {
    //    역시나 시간 초과
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken()); // 보석 개수
      int k = Integer.parseInt(st.nextToken()); // 가방 개수

      ArrayList<Jewelry> list = new ArrayList<>();
      int minWeight = 1_000_000;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());

        Jewelry jewelry = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        list.add(jewelry);

        minWeight = Math.min(minWeight, jewelry.weight);
      }

      list.sort(Comparator.comparingInt(j -> j.price));
      Collections.reverse(list);

      long price = 0L;

      PriorityQueue<Integer> bag = new PriorityQueue<>();

      for (int i = 0; i < k; i++) {
        bag.offer(Integer.parseInt(br.readLine()));
      }

      while (!bag.isEmpty()) {
        Integer current = bag.poll();

        if (current < minWeight) continue;

        int idx = 0;

        while (!list.isEmpty()) {
          if (list.size() <= idx) break;

          if (list.get(idx).weight <= current) {
            price += list.get(idx).price;
            list.remove(idx);
            break;
          } else {
            idx++;
          }
        }
      }

      System.out.print(price);
    }
  }
}
/*
3 3
20 12
0 20
16 16
17
14
7
=> 36

4 4
1 100
2 200
13 300
10 500
10
10
10
14
답 1100
 */