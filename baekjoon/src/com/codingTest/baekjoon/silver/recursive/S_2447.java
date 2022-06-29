package com.codingTest.baekjoon.silver.recursive;

import java.io.*;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class S_2447 {
  static class Draw {
    private final String PATTERN_1 = "***";
    private final String PATTERN_2 = "* *";
    private final String PATTERN_3 = "***";
    private String[] sbList;

    Draw(int size) {
      this.sbList = new String[size];
      Arrays.fill(sbList, "");
    }

    BiPredicate<Integer, Integer> isRemainEquals_0 = (num, division) -> num % division == 0;
    BiPredicate<Integer, Integer> isRemainEquals_1 = (num, division) -> num % division == 1;
    BiPredicate<Integer, Integer> isRemainEquals_2 = (num, division) -> num % division == 2;
    BiPredicate<Integer, Integer> isEmptyCondition = (n, value) -> n / 9 <= value && value < (n / 9) * 2;

    void addStars(int n, int level, int depth, int index) {
      if (depth != n) {
        if (isEmptyCondition.test(n, level)) {
          if (isRemainEquals_0.test(level, 2)) {
            this.addPatternB(n, level, depth, index);
          } else {
            this.addPatternA(n, level, depth, index);
          }
        } else {
          if (isRemainEquals_0.test(level, 2)) {
            this.addPatternA(n, level, depth, index);
          } else {
            this.addPatternB(n, level, depth, index);
          }
        }
      }
    }

    void addPatternA(int n, int level, int depth, int index) {
      if (index == n / 3) {
        addStars(n, isRemainEquals_2.test(depth, 3) ? level + 1 : level, depth + 1, 0);
      } else {
        if (isEmptyCondition.test(n, level) && isEmptyCondition.test(n, index)) {
          this.sbList[depth] += " ".repeat(3);
          addPatternA(n, level, depth, index + 1);
        } else {
          if (isRemainEquals_0.test(depth, 3)) this.sbList[depth] += PATTERN_1;
          if (isRemainEquals_1.test(depth, 3)) this.sbList[depth] += PATTERN_2;
          if (isRemainEquals_2.test(depth, 3)) this.sbList[depth] += PATTERN_3;
          addPatternA(n, level, depth, index + 1);
        }
      }
    }

    void addPatternB(int n, int level, int depth, int index) {
      if (index == n / 3) {
        addStars(n, isRemainEquals_2.test(depth, 3) ? level + 1 : level, depth + 1, 0);
      } else {
        if (isEmptyCondition.test(n, level) && isEmptyCondition.test(n, index)) {
          this.sbList[depth] += " ".repeat(3);
          addPatternB(n, level, depth, index + 1);
        } else {
          if (isRemainEquals_1.test(index, 3)) {
            this.sbList[depth] += " ".repeat(3);
          } else {
            if (isRemainEquals_0.test(depth, 3)) this.sbList[depth] += PATTERN_1;
            if (isRemainEquals_1.test(depth, 3)) this.sbList[depth] += PATTERN_2;
            if (isRemainEquals_2.test(depth, 3)) this.sbList[depth] += PATTERN_3;
          }
          addPatternB(n, level, depth, index + 1);
        }
      }
    }
  }

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Draw draw = new Draw(n);
    draw.addStars(n, 0, 0, 0);

    StringBuilder sb = new StringBuilder();
    for (String str : draw.sbList) {
      sb.append(str).append("\n");
    }
    System.out.print(sb);
  }
}

/*
 * 처음에는
 * ***
 * * *
 * ***
 *
 * 1 4 7 10 13 16
 * k-1 % 3 == 0 일때는 안찍네?
 *
 * 0 23 56 8
 *
 * 27/3/3
 * 9
 * 9
 *
 * 36/3
 * 12
 * 12
 *
 *  0   1   2   3   4   5   6   7   8
 * ***|***|***|   |   |   |***|***|***9 3
 *
 *  0   1   2   3   4   5   6   7   8   9   10  11  12
 * ***|***|***|***|***|   |   |   |   |***|***|***|***|9 3
 *
 *
 ***************************0 0
 * ** ** ** ** ** ** ** ** *1 0
 ***************************2 0
 ***   ******   ******   ***3 1
 * *   * ** *   * ** *   * *4 1
 ***   ******   ******   ***5 1
 ***************************6 2
 * ** ** ** ** ** ** ** ** *7 2
 ***************************8 2
 *********         *********9 3
 * ** ** *         * ** ** *10 3
 *********         *********11 3
 ***   ***         ***   ***12 4
 * *   * *         * *   * *13 4
 ***   ***         ***   ***14 4
 *********         *********15 5
 * ** ** *         * ** ** *16 5
 *********         *********17 5
 ***************************18 6
 * ** ** ** ** ** ** ** ** *19 6
 ***************************20 6
 ***   ******   ******   ***21 7
 * *   * ** *   * ** *   * *22 7
 ***   ******   ******   ***23 7
 ***************************24 8
 * ** ** ** ** ** ** ** ** *25 8
 ***************************26 8


 ***   ******   ******   ***
 * *   * ** *   * ** *   * *
 1 3   7 90 2   6 89 1   5 7
  2 456 8  1 345 7  0 234 6

* 앞뒤 더한게 짝수면 1번 비우고 홀수면 2번비우는 것 같은데, 그럼 안찍는게 어려우니까 패스
* 1 7 10

  * *   * **  *      * **   *     * *
* 1 3   7 910 12     16 1819 21   25 27
*  2 === 8   11  === 17    20   === 26    isEvenNumber.test((index / 3) % 3) && index +1 이 3의 약수인 것...
*  2 456 8   11 131415 17    20 222324 26


 */

//public class S_2447 {
//  static Predicate<Integer> isEvenNumber = num -> num % 2 == 0;
//  static Predicate<Integer> isMultipleOf3 = num -> num % 3 == 0;
//
//  public static void test() throws IOException {
//
//    printOneLine(27, 0, 0, 0);
//
//  }
//
//  /**
//   * ***************************
//   * * ** ** ** ** ** ** ** ** *
//   * ***************************
//   *
//   * @param n
//   * @param level
//   * @param depth
//   * @param index
//   */
//  static void a(int n, int level, int depth, int index) {
//    if (isEvenNumber.test(depth)) {
//      if (!isEvenNumber.test((index / 3) % 3)) {
//        System.out.print("   ");
//        printOneLine(n, level, depth, index + 3);
//      } else {
//        System.out.print((isMultipleOf3.test(index + 2)) ? " " : "*");
//        printOneLine(n, level, depth, index + 1);
//      }
//    } else {
//      if (!isEvenNumber.test((index / 3) % 3)) {
//        System.out.print("   ");
//        printOneLine(n, level, depth, index + 3);
//      } else {
//        System.out.print("*");
//        printOneLine(n, level, depth, index + 1);
//      }
//    }
//  }
//
//  /**
//   * ***   ******   ******   ***
//   * * *   * ** *   * ** *   * *
//   * ***   ******   ******   ***
//   *
//   * @param n
//   * @param level
//   * @param depth
//   * @param index
//   */
//  static void b(int n, int level, int depth, int index) {
//    if (isEvenNumber.test(depth)) System.out.print("*");
//    else System.out.print(isMultipleOf3.test(index - 1) ? " " : "*");
//
//    printOneLine(n, level, depth, index + 1);
//  }
//
//
//  static void printOneLine(int n, int level, int depth, int index) {
//    if (depth == n) return;
//
//    if (index == n) { // 한줄 다 찍었으면 depth +1 / depth 3의 배수면 level + 1
//      System.out.println();
////      System.out.printf("level: %d / depth: %d / index: %d \n\n", level, depth, index);
//      printOneLine(n, isMultipleOf3.test(depth + 1) ? level + 1 : level, depth + 1, 0);
//    }
//    if (index < n) {
//      if (isEvenNumber.test(level)) {
//
//        b(n, level, depth, index);
//      } else {
//        a(n, level, depth, index);
//      }
//    }
///*
// 1. level까지 쭉~~
// 2. (index-1)%3 == 0 일때는 공백
// 3.index-1 이 3으로 나눈 몫 - 1 이 3으로 나눠 떨어질 ㄸㅐ?ㅎ
//          111   111122   222223   333333
// 123   789012   678901   567890   456789
//   1     3  4     6  7     9  10    12 13   < index/3
//   1     0  1     0  1     0  1     0   1    < (index/3)%3 ==1 인애들 다음에 3칸 비
//
//
//              111     222       333
//    456       345     234       123
//
//   3   7     12  16   21  25   30   34
//
//   1          4       7       10
//   ㅠㅠㅠ index-1 이 3으로 나눈 몫 - 1 이 3으로 나눠 떨어질 ㄸㅐ?ㅎ
//
//   depth가 3씩 증가할 때 패턴이 바뀐다.
//
// */
//
//
//  }
//
//
//  //  망함
//  static void print3SquareLine(int level, int depth, int index) {
//    if (level == depth) return;
//    if (isEvenNumber.test(depth)) {
//      System.out.print("***\n* *\n***");
//      if (index == (level / 3)) {
//        System.out.println();
//        print3SquareLine(level, depth + 1, 0);
//      } else {
//        print3SquareLine(level, depth, index + 1);
//      }
//    } else {
//      if ((index - 1) % 3 == 0) {
//        System.out.print("   \n   \n   ");
//      } else {
//        System.out.print("***\n* *\n***");
//      }
//
//      if (index == (level / 3)) {
//        System.out.println();
//        print3SquareLine(level, depth + 1, 0);
//      } else {
//        print3SquareLine(level, depth, index + 1);
//      }
//    }
//  }
//
//  static String print3Square(int level, int index) {
//    StringBuilder sb = new StringBuilder();
//    if (isEvenNumber.test(level)) {
//      sb.append("***\n")
//          .append("* *\n")
//          .append("***")
//          .append(index == (level / 3) ? "\n" : print3Square(level, index + 1));
//    } else {
////      if((index-1)%3 == 0)
//      sb.append("***\n")
//          .append("* *\n")
//          .append("***")
//          .append(index == (level / 3) ? "\n" : print3Square(level, index + 1));
//
//    }
//    return sb.toString();
//  }
//}
//
///*
// * 처음에는
// * ***
// * * *
// * ***
// *
// * 1 4 7 10 13 16
// * k-1 % 3 == 0 일때는 안찍네?
// *
//
// ***************************
// * ** ** ** ** ** ** ** ** *
// ***************************
// ***   ******   ******   ***
// * *   * ** *   * ** *   * *
// ***   ******   ******   ***
// ***************************
// * ** ** ** ** ** ** ** ** *
// ***************************
// *********         *********
// * ** ** *         * ** ** *
// *********         *********
// ***   ***         ***   ***
// * *   * *         * *   * *
// ***   ***         ***   ***
// *********         *********
// * ** ** *         * ** ** *
// *********         *********
// ***************************
// * ** ** ** ** ** ** ** ** *
// ***************************
// ***   ******   ******   ***
// * *   * ** *   * ** *   * *
// ***   ******   ******   ***
// ***************************
// * ** ** ** ** ** ** ** ** *
// ***************************
//
//
// */