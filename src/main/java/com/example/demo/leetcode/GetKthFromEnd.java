package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/9/4 14:40
 */

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode high = head;
        ListNode low = head;
        //与下标不同，这里表示第几个节点，要从1开始
        int index = 1;
        //循环结束时，index = k,但是由于是从1开始，所以其实指向的是k-1个节点
        while (high != null && high.next != null && index < k) {
            high = high.next;
            index++;
        }

        //一起后移
        while (high.next != null) {
            high = high.next;
            low = low.next;
        }
        return low;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new GetKthFromEnd().getKthFromEnd(node1,2));

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
