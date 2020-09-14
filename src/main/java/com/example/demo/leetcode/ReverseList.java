package com.example.demo.leetcode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    //递归
//     next.next = cur ;cur.next = null;    返回最后节点即可
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;

        ListNode reverse = reverse(temp);

        temp.next = head;
        head.next = null;

        return reverse;
    }
    //三指针
    public ListNode reverse2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            //因为要断开next与head之间的联系，即让head的next指向前一个节点，所以要先记住next
            next = head.next;
            //head 指向前一个节点
            head.next = pre;

            //前一个节点后移指向head
            pre = head;
            //head后移
            head = next;
        }

        return pre;
    }



    //迭代
//    public ListNode reverseList(ListNode head) {
//
//    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode node = reverseList.reverse2(node1);

        while(node !=null){
            System.out.println(node.val+"-->");
            node = node.next;
        }

    }
}



