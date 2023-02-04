package doctor;

import java.util.*;

public class Test {
  public static void main(String[] args) {
    Solution1.test();
  }


  public static class Solution1 {
    public static void test() {
      int[][][] tc = {
          {{7, 8, 10}, {10, 7, 8}}, // true
          {{4, 3, 2, 1}, {5, 4, 1, 2}},  //false
          {{1500, 0, 0, 1, 2}, {2, 1500, 0, 0, 1}},  // true
      };

      boolean[] answer = {true, false, true};

      for (int i = 0; i < tc.length; i++) {
        System.out.println(solution1(tc[i][0], tc[i][1]) == answer[i]);
      }
    }

    public static boolean solution1(int[] arrA, int[] arrB) {
      if (arrA.length != arrB.length) {
        return false;
      }

      int length = arrA.length;

      ArrayList<Integer> movingCountList = new ArrayList<>();

      for (int i = 0; i < length; i++) {
        if (arrB[i] == arrA[0]) {
          movingCountList.add(i);
        }
      }

      if (movingCountList.size() == 0) {
        return false;
      }

      boolean isSame = true;

      for (int movingCount : movingCountList) {
        isSame = true;
        for (int j = 0; j < length; j++) {
          int movingIdx = (j + movingCount) % length;

          if (arrA[j] != arrB[movingIdx]) {
            isSame = false;
            break;
          }
        }

        if(isSame){
          break;
        }
      }

      return isSame;
    }
  }

  public static class Solution2 {
    public static void test() {
      int[][][] tc = {
          {{1, 3}, {3, 1}, {3, 5}, {5, 3}, {2, 5}}
      };
      int[] answer = {2};

      for (int i = 0; i < tc.length; i++) {
        System.out.println(solution(tc[i]) == answer[i]);
      }
    }

    public static int solution(int[][] p) {
      TreeMap<Integer, Employee> employeeList = new TreeMap<>();
      int answer = 0;

      for (int[] survey : p) {
        int participatedId = survey[0];
        int favoriteEmployeeId = survey[1];

        Employee employee = employeeList.getOrDefault(participatedId, new Employee(participatedId));
        employee.addFavorite(favoriteEmployeeId);

        employeeList.put(participatedId, employee);
      }

      for (Integer employeeId : employeeList.keySet()) {
        Employee employee = employeeList.get(employeeId);

        for (Integer favoriteEmployeeId : employee.favoriteEmployeeIdList) {
          if (!employeeList.containsKey(favoriteEmployeeId)) {
            continue;
          }

          Employee favoriteEmployee = employeeList.get(favoriteEmployeeId);

          if (favoriteEmployee.isFavoriteEmployee(employee.id)) {
            answer++;
            favoriteEmployee.removeFavoriteId(employeeId);
          }
        }
      }

      return answer;
    }

    static class Employee {
      int id;
      LinkedList<Integer> favoriteEmployeeIdList = new LinkedList<>();

      public Employee(int id) {
        this.id = id;
      }

      void addFavorite(int id) {
        favoriteEmployeeIdList.add(id);
      }

      void removeFavoriteId(Integer id) {
        favoriteEmployeeIdList.remove(id);
      }

      boolean isFavoriteEmployee(Integer id) {
        return favoriteEmployeeIdList.contains(id);
      }
    }
  }

  public static class Solution3 {
    // 1-> . Q Z 46 81 90
    // A 65  D 68  G 71  J 74  M 77
    // 7-> P 80 R 82 S 83
    // T 84 W 87

    public static void test() {
      String[] tc = {
          "44335550555666",
          "9666775553",
          "2220281"
      };

      String[] answer = {
          "HELLO",
          "WORLD",
          "CAT."
      };

      for (int i = 0; i < tc.length; i++) {
        System.out.println(answer[i].equals(solution(tc[i])));
      }
    }

    public static String solution(String s) {
      StringBuilder answer = new StringBuilder();

      int beforeNumber = s.charAt(0) - '0';
      int count = 1;

      for (int i = 1; i < s.length(); i++) {
        int currentNumber = s.charAt(i) - '0';

        if (beforeNumber == currentNumber) {
          count++;
          continue;
        }

        if (beforeNumber != 0) {
          answer.append(getAlphabet(beforeNumber, count));
        }

        beforeNumber = currentNumber;
        count = 1;
      }

      answer.append(getAlphabet(beforeNumber, count));

      return answer.toString();
    }

    public static char getAlphabet(int keypadNumber, int count) {
      return (char) getAscii(keypadNumber, count);
    }

    public static int getAscii(int keypadNumber, int count) {
      int[] startAsciiCode = {-1, 46, 65, 68, 71, 74, 77, 80, 84, 87};

      return switch (keypadNumber) {
        case 1 -> {
          if (count == 1) yield startAsciiCode[keypadNumber];
          if (count == 2) yield 81;
          yield 90;
        }
        case 7 -> {
          if (count == 1) yield startAsciiCode[keypadNumber];
          yield startAsciiCode[keypadNumber] + count;
        }

        default -> startAsciiCode[keypadNumber] + count - 1;
      };
    }
  }

  public static class Solution4 {
    static StringBuilder[] sbList;

    static void test() {
      int[] tc = {2, 5};
      String[] answer = {"11", "122111"};

      for (int i = 0; i < tc.length; i++) {
        System.out.println(answer[i].equals(solution4(tc[i])));
      }
    }

    public static String solution4(int n) {
      sbList = new StringBuilder[n];

      for (int i = 0; i < n; i++) {
        sbList[i] = new StringBuilder();
      }

      sbList[0].append(1);

      for (int i = 1; i < n; i++) {
        int beforeLength = sbList[i - 1].length();

        for (int j = 0; j < beforeLength; ) {
          char current = sbList[i - 1].charAt(j);
          int begin = j;

          while (++j < beforeLength && (current == sbList[i - 1].charAt(j))) {
          }

          sbList[i].append(current).append(j - begin);
        }
      }

      return sbList[n - 1].toString();
    }
  }

  public static class Solution5 {
    static int[][] answer;
    static int[][] visited;
    static boolean[][] busStop;

    public static void test() {
      int[][][] tc = {
          {{1, 2}},  // {1, 0, 1}, {2, 1, 2}, {3,2,3}
          {{1, 1}},  // {0, 0}
      };
      int[][][] answer = {
          {{1, 0, 1}, {2, 1, 2}, {3, 2, 3}}, {{0, 0}}
      };

      System.out.println(Solution5.solution5(3, tc[0]) == answer[0]);
      System.out.println(Solution5.solution5(1, tc[1]) == answer[1]);
    }

    public static int[][] solution5(int N, int[][] bus_stop) {
      answer = new int[N][N];

      if (bus_stop.length == N * N) {
        return answer;
      }

      visited = new int[N][N];
      busStop = new boolean[N][N];

      for (int[] coordinate : bus_stop) {
        int row = coordinate[0] - 1;
        int col = coordinate[1] - 1;

        busStop[row][col] = true;
      }

      int visitedNumber = 1;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (busStop[i][j]) {
            continue;
          }

          answer[i][j] = bfs(new Coordinate(i, j, visitedNumber, 0));

          visitedNumber++;
        }
      }

      return answer;
    }

    static int bfs(Coordinate coordinate) {
      Queue<Coordinate> queue = new LinkedList<>();
      queue.offer(coordinate);

      //  동 남 서 북 순서 탐색
      int[] rowDirection = {0, 1, 0, -1};
      int[] columnDirection = {1, 0, -1, 0};

      while (!queue.isEmpty()) {
        Coordinate current = queue.poll();

        int row = current.row;
        int col = current.col;
        int visitNumber = current.visitNumber;
        int distance = current.distance;

        for (int i = 0; i < 4; i++) {
          Coordinate next = new Coordinate(row + rowDirection[i], col + columnDirection[i], visitNumber, distance + 1);

          if (!next.isValid()) {
            continue;
          }

          if (next.isBusStop()) {
            return next.distance;
          }

          next.markVisit();
          queue.offer(next);
        }
      }

      return -1;
    }

    static class Coordinate {
      int row;
      int col;
      int visitNumber;
      int distance;

      public Coordinate(int row, int col, int visitNumber, int distance) {
        this.row = row;
        this.col = col;
        this.visitNumber = visitNumber;
        this.distance = distance;
      }

      public boolean isBusStop() {
        return busStop[row][col];
      }

      public boolean isValid() {
        return withinRange() && !isVisited();
      }

      public void markVisit() {
        visited[row][col] = visitNumber;
      }

      public boolean isVisited() {
        return visited[row][col] == visitNumber;
      }

      public boolean withinRange() {
        return 0 <= row && row < answer.length && 0 <= col && col < answer[0].length;
      }
    }
  }
}
