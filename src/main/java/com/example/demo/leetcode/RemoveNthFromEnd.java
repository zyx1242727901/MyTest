package com.example.demo.leetcode;

import java.sql.SQLOutput;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 *
 * 解析：
 * 优秀！！！！！！！
 * 优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n-1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = head;
        ListNode tailNode = head;

        for(int i=0;i<n;i++){
            tailNode = tailNode.next;
        }
        if(tailNode == null){
            tempHead = head.next;
        }else{
            //tailNode移至尾结点，此时head指向倒数第n个元素的前面一个节点
            while(tailNode.next != null){
                tailNode = tailNode.next;
                head = head.next;
            }
            head.next = head.next.next;
        }

        return tempHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
//        ListNode h3 = new ListNode(3);
//        ListNode h4 = new ListNode(4);
//        ListNode h5 = new ListNode(5);
        head.next = h2;
//        h2.next = h3;
//        h3.next = h4;
//        h4.next = h5;

        ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(head, 1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
