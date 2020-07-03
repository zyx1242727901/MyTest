package com.example.demo.leetcode;


//  给定一个二叉树，找出其最大深度。
//
//  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//  说明: 叶子节点是指没有子节点的节点。
//
//  示例：
//  给定二叉树 [3,9,20,null,null,15,7]，
//  返回它的最大深度 3
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        //结束条件
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);


        return Math.max(leftHeight,rightHeight)+1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(27);
        root.left.left = null;
        root.left.right = null;

        System.out.println(new MaxDepth().maxDepth(root));
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


