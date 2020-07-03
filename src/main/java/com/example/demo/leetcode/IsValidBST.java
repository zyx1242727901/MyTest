package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class IsValidBST {
    List<Integer> betweenOrderList = new ArrayList<>();
    //
    public boolean isValidBST(TreeNode root) {
//        betweenOrder(root);
//        return validOrderList();
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode node, long lower, long upper){
        if (node == null) {
            return true;
        }
        //逻辑
        if (lower >= node.val || upper <= node.val) {
            return false;
        }
        //递归
        //左数的最大值为当前节点,右数最小值为当前节点， 剩余lower与upper为上级节点传入的值
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

//    // ========中序遍历解法  start==================
//    public void betweenOrder(TreeNode root){
//        if (root == null) {
//            return;
//        }
//
//        betweenOrder(root.left);
//        betweenOrderList.add(root.val);
//        betweenOrder(root.right);
//    }
//    public boolean validOrderList(){
//        if (betweenOrderList.size() == 0) {
//            return true;
//        }
//        int between = betweenOrderList.get(0);
//        for (int i = 1; i < betweenOrderList.size(); i++) {
//            if (betweenOrderList.get(i) <= between) {
//                return false;
//            }
//            between = betweenOrderList.get(i);
//        }
//        return true;
//    }
//    // ========中序遍历解法   end==================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.left.left = null;
        root.left.right = null;

        System.out.println(new IsValidBST().isValidBST(root));
    }
}

