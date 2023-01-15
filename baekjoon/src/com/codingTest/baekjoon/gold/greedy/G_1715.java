package com.codingTest.baekjoon.gold.greedy;

import java.io.*;
import java.util.*;

public class G_1715 {
  // https://www.acmicpc.net/problem/1715
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> cardList = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      cardList.offer(Integer.parseInt(br.readLine()));
    }

    if (n == 1) {
      System.out.print(0);  // 카드가 1개일 때 그 카드의 수를 출력하면 안되고, 카드 비교를 안하니까 비교횟수인 0을 출력해야한다...ㅎㅎ 그래서 틀렸었음!
      return;
    }

    int sum = 0;

    while (1 < cardList.size()) {
      int add = cardList.poll() + cardList.poll();
      sum += add;
      cardList.offer(add);
    }

    System.out.print(sum);
  }

  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] cardList = new int[n];

    for (int i = 0; i < n; i++) {
      cardList[i] = Integer.parseInt(br.readLine());
    }

    if (n == 1) {
      System.out.println(cardList[0]);
      return;
    }

    Arrays.sort(cardList);

    Stack<Integer> sumOneByOne = new Stack<>(); // 하나 씩 합친다.
    Queue<Integer> twoCardSet = new LinkedList<>();  // 두개 씩 미리 묶은 뒤 합친다.

    sumOneByOne.push(cardList[0] + cardList[1]);
    twoCardSet.offer(cardList[0] + cardList[1]);

//    여기서도 정렬을 해줬어야함 -> priority queue에 넣어주면 되는거였네
    for (int i = 2; i < n; i++) {
      sumOneByOne.push(sumOneByOne.peek() + cardList[i]);
      if (i % 2 == 0 && i != n - 1) { // 2개씩 묶어준다.
        twoCardSet.offer(cardList[i] + cardList[i + 1]);
      }
    }

    int sum = 0;

    while (!sumOneByOne.isEmpty()) {
      sum += sumOneByOne.pop();
    }

// 미리 두개씩 섞는다는 잘못된 정해때문에 이꼬라쥐,,,
    Stack<Integer> sumTwoByTwo = new Stack<>();

    int setSum = 0;
    PriorityQueue<Integer> priorityCardSet = new PriorityQueue<>();

    while (!twoCardSet.isEmpty()) {
      int set = twoCardSet.poll();
      setSum += set;
      priorityCardSet.offer(set);
    }

    if (n % 2 == 1) { // 카드 개수가 홀수면 마지막 카드 넣어주기
      priorityCardSet.offer(cardList[n - 1]);
    }

    while (1 < priorityCardSet.size()) {
      int s = priorityCardSet.poll() + priorityCardSet.poll();
      sumTwoByTwo.push(s);
      priorityCardSet.offer(s);
    }

    while (!sumTwoByTwo.isEmpty()) {
      setSum += sumTwoByTwo.pop();
    }

    System.out.println(Math.min(sum, setSum));
  }
}

    /*
      1 2 3 4 5
      add (a, b) -> a + b

      10 20 40
      1. 합친 값을 저장한다.   10 + 20 = 30
      2. 합친 값과 그 다음 값을 합친 값을 저장한다. 30 + 40 = 70
      3. 합친 값과 그 다음 합친 값을 합친다. = 정답  30 + 70 = 100

      합친 값을 저장함 => 어디에? => 특정 값의 첫번째 인덱스에? => 첫번째라는게 애매하네.... => 뒤에 더한 값의 인덱스에?
      5
      10
      20
      40
      50
      100
      10  20  40  50  100
      0   1   2   3   4

      [1]
      0 + 1 => 1번째 인덱스  30
      1 + 2 => 2번째 인덱스  70
      2 + 3 => 3번째 인덱스  120
      3 + 4 => 4번째 인덱스  220
      얘네를 다 저장하면 정답: 440

      [2]
      10  20  40  50  100
      0   1   2   3   4
      2개씩 묶는다면? 짝수에 해야 홀수 개수일 때 마지막 값을 더할 수 있을 듯!
      0 + 1 => 0번째 인덱스  30
      2 + 3 => 2번째 인덱스  90
      4 -> 짝 없으므로 대기

      그다음에 [1]의 방법 시행
      안되면 인덱스를 0 1 2 순서대로 넣어준 뒤
      0 + 1 => 120
      1 + 2 => 220
      => 다 더하면 460

      0 + 2 => 2번째...이러면 덮어씌워지네.....  120
      2 + 4 =>  220
      얘네 다 더하면 460
    */

/* 반례 및 테케 : https://www.acmicpc.net/board/view/72799
5
120
40
100
20
30

20 30 40 100 120


20 30 = 50
<40 50 100 120>
40 50 = 90
<90 100 120>
90 100 = 190
120 190 = 310
50+90+190+310=640

[1]
20+30   50
50+40   90
90+100  190
190+120 310
        640

[2]
20+30   50
40+100  140
120
-- 여기까지가 queue 저장

50+120  170
170+140 310
        670
----
->> 50 + 140일때 50 + 120인 경우가 더 작게 계산됨!! 이래서 우선순위 큐를 쓰는건가??
50+140  190
190+120 310
        690

에러 -> 큐에는 50, 120, 140이 존재
얘네는 그대로 나둔 채로 각각의 합을 또 더해줘야함...

세트인 50이랑 140은 sum에 저장 + stack에 추가
짝지 없는 애 stack에 추가

stack에 있는 놈들 [1] 방식 적용
50 120 140

50+120  170
170+140 310
얘네 더한 후 위의 sum이랑 더하기


4
30
40
50
100
=> 410

<30 40 50 100>
30 40 = 70
<50 70 100>
50 70 = 120
100 120 = 220
70+120+220=410


1. 2장 + 1장 비교
(((30 + 40) + 50) + 100)
70 + 50 + 120 + 100 = 410

2. 2장 + 2장 비교
((30 + 40) + (50 + 100))
(70 + 150) * 2 = 440
-----------
4
30
40
50
60
=> 360

<30 40 50 60>
30 + 40 = 70
>> 여기서 정렬을 안해줘서 최소 값이 안나왔구나..!!! 2번의 경우는 생각할 필요도 없었음!!!
<50 60 70>
50 + 60 = 110
70 + 110 = 180
70+110+180=360


1. 2장 + 1장 비교
(((30 + 40) + 50) + 60)
70 + 50 + 120 + 60 = 370

2. 2장 + 2장 비교
((30 + 40) + (50 + 60))
70 + 110 = (180 * 2) = 360

8
30
40
50
20
10
100
60
10
=> 860

정렬
10
10
20  
30    
40  
50
60
100

[1]
10  10  20
20  20  40
40  30  70
70  40  110
110 50  160
160 60  220
220 100 320
=       940


[2]
10  10    20
20  30    50
40  50    90
60  100   160
-1-
20  50    70
70  90    160
160 160   320
=         870   => 860이어야 함...

4
3
3
3
3
=> 24
 */