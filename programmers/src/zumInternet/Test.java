package zumInternet;

import java.util.PriorityQueue;

public class Test {
  public static void main(String[] args) {
    int[] s1TC = {
        1, 2, 3, 100_000
    };

    int[][][] s2TC = {
        {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}}, // [1, 3, 4, 2, 5]
        {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}}, // [1,3,2,4,5]
        {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}},  // [1,2,4,5,3]
        {{1, 10, 2}, {2, 11, 3}, {3, 12, 2}, {4, 15, 10}, {5, 16, 2}},  //  [1, 3, 2, 5, 4]
        {{1, 99_999_999, 100_000}, {2, 100_000_000, 4}},  // [1, 2]
        {{1, 99_999_997, 3}, {2, 99_999_999, 4}, {3, 100_000_000, 2}},  // [1, 3, 2]
    };

    int[][] s3TC = {
//        최대 개수 100,000개
//        최대 높이 10,000
        {2, 2, 2, 3},
        {6, 5, 7, 3, 4, 2},
        {1, 10, 9, 5, 6, 7, 3},
        {10000, 1, 9999, 5, 60, 510, 51, 2, 3, 5, 1, 55, 6},
        {10000, 1, 9, 5, 60, 510, 51, 2, 3, 5, 1, 55, 6},
        {10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 10_000, 1}
    };
    int[][][] s4TC = {
        {{2, 1, 1, 3, 5, 1}, {1, 1, 3, 3, 5, 5}, {8, 3, 3, 3, 1, 5}, {3, 3, 3, 4, 4, 4}, {3, 3, 4, 4, 4, 4}, {1, 4, 4, 4, 4, 4}},  // [3, 2]
        {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}}  //  [1, 9]
    };

    for (int i = 0; i < s1TC.length; i++) {
      print(Test.Solution1.solution(s1TC[i]));
    }
//    print(Test.Solution2.solution(s2TC[4]));
  }

  public static class Solution1 {
    public static long solution(long n) {
        /*
            num % n == num / n
            (num > n)
            n: num
            2: 3
            3: 4, 8
            4: 5, 10, 15
            5: 6, 12, 18, 24

            num = n+1부터 배수로 진행 ~ num보다 작을 때까지
        */
      long answer = 0;

      // n+1은 무조건 몫과 나머지가 같음
      long minValue = (n + 1);

      // (n+1)의 n-1번째 배수까지 더하기
      for (int i = 1; i < n; i++) {
        answer += (minValue * i);
      }

      return answer;
    }
  }

  public static class Solution2 {
    //    https://programmers.co.kr/app/with_setting/tests/27649/challenges/algorithms/5562
    /*
    우선순위 큐
    1페이지 인쇄 시 1초 소요
    1. 요청 문서가 없다면 바로 인쇄
    2. 인쇄중 or 대기 중이라면 대기열 추가
    3. 페이지 수가 적은 것
    4. 페이지 수가 동일하다면 먼저 요청된 문서부터
    5. 현재 인쇄가 끝나는 시간과 요청된 시간이 동일하다면 2번부터 실행
     */
    static int[] answer;

    public static int[] solution(int[][] data) {
      answer = new int[data.length];

      Print print = new Print();

      // 인쇄해야하는 문서 추가 + 프린트
      for (int[] info : data) {
        Document document = setDocument(info);

        // 프린트 종료 시간과 현재 인쇄 요청시간 사이에 텀이 있다면 기존 대기 목록 프린트
        while (!print.isEmpty() && print.endTime < document.requestTime) {
          print.printing();
        }

        print.addDocument(document);

        // 프린트 종료시간과 현재 인쇄 요청 시간이 같다면 우선순위에 따라 프린트 하기
        if (print.endTime <= document.requestTime) {
          print.printing();
        }
      }

      // 아직 인쇄 안한 문서가 있다면 우선순위에 따라 프린트
      while (!print.isEmpty()) {
        print.printing();
      }

      return answer;
    }

    static Document setDocument(int[] document) {
      return new Document(document[0], document[1], document[2]);
    }

    static class Print {
      int printSequence = 0;
      int endTime = 0;
      PriorityQueue<Document> printList = new PriorityQueue<>((d1, d2) -> {
        if (d1.pageCount == d2.pageCount) {
          return d1.documentNum - d2.documentNum;
        }
        return d1.pageCount - d2.pageCount;
      });

      void addDocument(Document document) {
        printList.add(document);
      }

      boolean isEmpty() {
        return printList.isEmpty();
      }

      void printing() {
        if (isEmpty()) {
          return;
        }

        Document printing = printList.poll();

        answer[printSequence++] = printing.documentNum;
        endTime = printing.getEndTime(Math.max(printing.requestTime, this.endTime));
      }
    }

    static class Document {
      int documentNum;
      int requestTime;
      int pageCount;

      public Document(int documentNum, int requestTime, int pageCount) {
        this.documentNum = documentNum;
        this.requestTime = requestTime;
        this.pageCount = pageCount;
      }

      public int getEndTime(int startTime) {
        return startTime + pageCount;
      }
    }
  }

  public static class Solution3 {
    /*
        가로 간격이 가장 멀면서, 세로가 가장 높은 값을 구한다.

        왼쪽 기준점을 정하는 방식 (거리가 가장 멀다. + 높이가 높다)

        아니면 for문 돌리는데 동시에 값을 구하면?
        l = left, r = right

        1. l = 0, r = length-1 -> 넓이 값 저장
        2. 만약 l++, r-- 중 현재 값보다 넓이가 크다면
        3. max 비교 후 위치 저장 + 넓이값 저장
    */
    public static int solution(int[] histogram) {
      // 처음과 끝을 기준으로 잡음
      int leftIdx = 0, rightIdx = histogram.length - 1;
      int max = getMaxArea(histogram, leftIdx, rightIdx);

      while (leftIdx < rightIdx) {
        int nextLeft = leftIdx + 1;
        int nextRight = rightIdx - 1;

        // 한칸 옆(+1)에 있는 히스토그램이 더 높으면
        if (histogram[leftIdx] < histogram[nextLeft]) {
          max = Math.max(max, getMaxArea(histogram, nextLeft, rightIdx));
          leftIdx = nextLeft;
          continue;
        }

        // 한칸 옆(-1)에 있는 히스토그램이 더 높으면
        if (histogram[rightIdx] < histogram[nextRight]) {
          max = Math.max(max, getMaxArea(histogram, leftIdx, nextRight));
          rightIdx = nextRight;
          continue;
        }

        // 옆 칸에 있는 히스토그램이 더 큰 경우가 없다면
        // 왼쪽과 오른쪽 중 낮은 칸을 옆으로 이동한다.
        if (histogram[leftIdx] < histogram[rightIdx]) {
          leftIdx = nextLeft;
        } else {
          rightIdx = nextRight;
        }
      }

      return max;
    }

    static int getMaxArea(int[] histogram, int leftIdx, int rightIdx) {
      int height = Math.min(histogram[leftIdx], histogram[rightIdx]);
      int width = rightIdx - leftIdx - 1;

      return height * width;
    }
  }

  public static class Solution4 {
    /*
        현재 칸과 인접한 상하좌우 칸 중 동일한 숫자가 있는지 확인

        1칸 씩 격차가 생겨야 함

        현재 칸의 레벨(n이 몇인지)
        현재 칸의 index 확인 => 몇층인지

    */

    /*
      상하좌우에 인접한 칸이 있으면 탐색해야하는데
      어느 방향으로 탐색하는 것이 크기가 더 클지도 생각해야함.
      visited를 몇차원으로 나두는 것이 맞을까??
      왼쪽으로 뻗어나가는 경우는 없음
      오른쪽, 위, 아래 3가지 방향

      그럼 오른쪽으로 갔을 때 방문한 경로는 [0][][]
      위쪽으로 갔을 때 방문한 경로는 [1][][]
      아래쪽은 [2][][]
     */

    /*
        시작한 지점에서 만들 수 있는 최대 마름모 꼴 구하기
        입출력 예 #3
        1,0 -> 오른쪽 위방    1,1 -> 오른쪽 위
        0,0 -> 왼쪽 아래방    0,1 -> 오른쪽 아래

        */
    static boolean[][] visited;    // 방문 표시

    public static int[] solution(int[][] grid) {
      visited = new boolean[grid.length][grid[0].length];

      int[] answer = {};


      return answer;
    }
  }

  static void print(Object o) {
    System.out.println(o);
  }
}
