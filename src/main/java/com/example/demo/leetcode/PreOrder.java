package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个 N 叉树，返回其节点值的前序遍历
 */
public class PreOrder {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);

            if (root.children != null) {
                for (Node child : root.children) {
                    preorder(child);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
