package com.example.demo.leetcode;

/**
 * zhangyuxiao
 * 2020/11/4 17:09
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //tempA和tempB我们可以认为是A,B两个指针
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA == null || tempB == null || tempA.val != tempB.val) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA = tempA == null ? headB : tempA.next;
            //指针tempB同上
            tempB = tempB == null ? headA : tempB.next;
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(2).setNext(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.setNext(7).setNext(9).setNext(2).setNext(1);

        System.out.println(new GetIntersectionNode().getIntersectionNode(listNode,listNode2));
    }

}
