package codingTest.leetcode.problems.Easy;

import java.util.Arrays;
import java.util.Stack;

public class June_5 {
  public boolean isValid(String s) {
    Stack<Character> brackets = new Stack();
    Stack<Character> waitClose = new Stack();

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

  public String longestCommonPrefix1(String[] strs) {
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
