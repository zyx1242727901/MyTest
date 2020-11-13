package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/11/4 19:51
 */
public class IsBalanced {

    int max = 0;
    public boolean isBalanced(TreeNode root) {
        if (root != null) {

            int left = depth(root.left, 1);
            max = 0;
            int right = depth(root.right, 1);
            max = 0;
            if (Math.abs(left - right) > 1) {
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }

    public int depth(TreeNode root, int level) {
        if (root != null) {
            max = Math.max(max, level);

            depth(root.left, level + 1);
            depth(root.right, level + 1);
            return max;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(6);
        root.left.left = null;
        root.left.right = null;

        System.out.println(new IsBalanced().isBalanced(root));
    }
}
