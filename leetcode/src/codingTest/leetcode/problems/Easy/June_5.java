package codingTest.leetcode.problems.Easy;

import java.util.Arrays;
import java.util.Stack;

import codingTest.leetcode.problems.Easy.definition.*;

public class June_5 {

  /**
   * 21. Merge Two Sorted Lists
   * TODO: solved again later
   * (더) 헷갈렸던 이유:
   * list1과 list2는 자체적으로 정렬된 상태인데, 그게 아닌 줄 알고있었음. 문제를 잘 읽어볼 것
   **/
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    ListNode sorted = new ListNode();
    if (list1.val < list2.val) {
      sorted.val = list1.val;
      sorted.next = mergeTwoLists(list1.next, list2);
    } else {
      sorted.val = list2.val;
      sorted.next = mergeTwoLists(list1, list2.next);
    }

    return sorted;
  }
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */

  /**
   * 20. Valid Parentheses
   **/
  public boolean validParentheses(String s) {
//    열어주는 bracket을 stack에 담을 필요는 없으니까... 이렇게 하나만 있으면 되는구나
    Stack<Character> brackets = new Stack<>();

    for (char bracket : s.toCharArray()) {
//      열어주는 괄호일 경우에는
      if (getReverseBracket(bracket) != ' ') {
//        stack에 반대로 닫아주는 놈을 넣어주고
        brackets.push(getReverseBracket(bracket));
//        닫아주는 괄호일 경우, stack이 비어있는 지 확인한 다음 하나 꺼내서 지금 닫아주는 bracket과 동일한 괄호인지 확인
      } else if (brackets.empty() || brackets.pop() != bracket) {
        return false;
      }
    }
//    다 닫아줬으면 true일 것이고 혹시 아니면 false
    return brackets.empty();
  }

  public boolean validParentheses_1(String s) {
    Stack<Character> brackets = new Stack<>();
    Stack<Character> waitClose = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      brackets.push(s.charAt(i));
    }

    while (!brackets.empty()) {
      char bracket = brackets.pop();

      if (waitClose.empty()) {
        waitClose.push(bracket);
      } else {
        if (waitClose.peek() == getReverseBracket(bracket)) {
          waitClose.pop();
        } else {
          waitClose.push(bracket);
        }
      }
    }

    return waitClose.empty();
  }

  char getReverseBracket(char bracket) {
    return switch (bracket) {
      case '(' -> ')';
      case '[' -> ']';
      case '{' -> '}';
      default -> ' ';
    };
  }

  /**
   * 14. Longest Common Prefix
   **/
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) return strs[0];

    Arrays.sort(strs);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs[0].length(); i++) {
      char prefix = strs[0].charAt(i);

      if (strs[strs.length - 1].indexOf(prefix, i) == i) {
        sb.append(prefix);
      } else {
        break;
      }
    }

    return sb.toString();
  }

  public String longestCommonPrefix_1(String[] strs) {
    if (strs.length == 1) {
      return strs[0];
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < strs[0].toCharArray().length; i++) {
      char prefix = strs[0].charAt(i);
      boolean isSame = false;

      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() <= i) {
          isSame = false;
          break;
        }

        isSame = prefix == strs[j].charAt(i);

        if (!isSame) break;
      }

      if (isSame) {
        sb.append(prefix);
      } else {
        break;
      }
    }

    return sb.toString();
  }
}
