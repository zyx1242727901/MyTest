package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangyuxiao
 * 2020/10/12 17:20
 *
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 */
public class ThreeOrders {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] array = new int[3][];
        array[0] = listToArray(first(new ArrayList<>(), root));
        array[1] = listToArray(mid(new ArrayList<>(), root));
        array[2] = listToArray(last(new ArrayList<>(), root));
        return array;
    }

    public List<Integer> first(List<Integer> list, TreeNode root){
        if (root != null) {
            list.add(root.val);
            first(list,root.left);
            first(list,root.right);
        }
        return list;
    }

    public List<Integer> mid(List<Integer> list, TreeNode root){
        if (root != null) {
            mid(list, root.left);
            list.add(root.val);
            mid(list, root.right);
        }
        return list;
    }

    public List<Integer> last(List<Integer> list, TreeNode root){
        if (root != null) {
            last(list,root.left);
            last(list,root.right);
            list.add(root.val);
        }
        return list;
    }

    public int[] listToArray(List<Integer> list){
        if (list != null) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        treeNode.left = left;
        TreeNode right = new TreeNode(3);
        treeNode.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        int[][] threeOrders = new ThreeOrders().threeOrders(treeNode);
        for (int[] threeOrder : threeOrders) {
            for (int i : threeOrder) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
