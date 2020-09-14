package com.example.demo.leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        ListNode resultNode = new ListNode(0);
//        ListNode curNode = resultNode;
//
//        while (l1!=null && l2 != null){
//            if(l1.val < l2.val){
//                curNode.next = l1;
//                l1 = l1.next;
//            }else{
//                curNode.next = l2;
//                l2 = l2.next;
//            }
//            curNode = curNode.next;
//        }
//
//        if(l1 != null){
//            curNode.next = l1;
//        }else if(l2 != null){
//            curNode.next = l2;
//        }
//        return resultNode.next;
//    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode curNode = resultNode;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        //结束后剩余的那个列表直接拼到后面
        if(l1 != null){
            curNode.next = l1;
        }else if(l2 != null){
            curNode.next = l2;
        }
        return resultNode.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(4);

        ListNode h4 = new ListNode(1);
        ListNode h5 = new ListNode(3);
        ListNode h6 = new ListNode(4);

        h1.next = h2;
        h2.next = h3;

        h4.next = h5;
        h5.next = h6;

        ListNode listNode = new MergeTwoLists().mergeTwoLists2(h1,h4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
