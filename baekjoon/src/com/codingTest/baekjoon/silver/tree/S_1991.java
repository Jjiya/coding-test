package com.codingTest.baekjoon.silver.tree;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * root = Math.floor(leaf / 2);
 * l_leaf = root * 2;
 * r_leaf = root * 2 + 1;
 */
public class S_1991 {
  static HashMap<String, String[]> tree;
  static StringBuilder sb = new StringBuilder();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    tree = new HashMap<>(n);
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String root = st.nextToken();
      String[] leaves = new String[2];

      for (int j = 0; j < 2; j++) {
        leaves[j] = st.nextToken();
      }

      tree.put(root, leaves);
    }

    preorder("A");
    sb.append("\n");

    inorder("A");
    sb.append("\n");

    postorder("A");

    System.out.print(sb);
  }

  /**
   * 전위 순회
   * (루트) > (왼쪽 자식) > (오른쪽 자식)
   *
   * @param root 현재 부모 node
   */
  static void preorder(String root) {
    sb.append(root);

    for (String leaf : tree.get(root)) {
      if (!leaf.equals(".")) {
        preorder(leaf);
      }
    }
  }

  /**
   * 중위 순회
   * (왼쪽 자식) > (루트) > (오른쪽 자식)
   *
   * @param root 현재 부모 node
   */
  static void inorder(String root) {
    String[] leaf = tree.get(root);
    String left = leaf[0];
    String right = leaf[1];

    if (!left.equals(".")) {
      inorder(left);
    }

    sb.append(root);

    if (!right.equals(".")) {
      inorder(right);
    }
  }

  /**
   * 후위 순회
   * (왼쪽 자식) > (오른쪽 자식) > (루트)
   *
   * @param root 현재 부모 node
   */
  static void postorder(String root) {
    String[] leaf = tree.get(root);
    String left = leaf[0];
    String right = leaf[1];

    if (!left.equals(".")) {
      postorder(left);
    }

    if (!right.equals(".")) {
      postorder(right);
    }

    sb.append(root);
  }
}