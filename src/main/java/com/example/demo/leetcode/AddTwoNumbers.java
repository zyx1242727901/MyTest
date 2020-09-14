package com.example.demo.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}

        public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this.next;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  //解决第一个节点的问题
        int carry = 0;
        ListNode curNode = head;
        while(l1 != null || l2 != null || carry > 0){
            int l1Val = l1 == null ? 0:l1.val;
            int l2Val = l2 == null ? 0:l2.val;

            int sum = (l1Val + l2Val + carry);
            carry = sum/10;
            ListNode temp = new ListNode(sum % 10);
            curNode.next = temp;
            curNode = curNode.next;


            l1 = l1 != null ? l1.next:null;
            l2 = l2 != null ? l2.next:null;
        }
        return head.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  //解决第一个节点的问题
        ListNode curNode = head;
        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0: l1.val;
            int l2Value = l2 == null ? 0: l2.val;
            int sum = l1Value + l2Value;
            int carry = sum/10; //余数
            int curr = sum % 10;

            l1 = l1 == null ? null: l1.next;
            l2 = l2 == null ? null : l2.next;

            //余数直接给下一个l1或l2节点加上即可
            if (l1 == null) {
                if (carry > 0) {
                    l1 = new ListNode(carry);
                }
            } else {
                l1.val = l1.val + carry;
            }

            curNode.next = new ListNode(curr);
            curNode = curNode.next;
        }
        return head.next;
    }


    //递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        l1 = l1 == null ? new ListNode(0): l1;
        l2 = l2 == null ? new ListNode(0) : l2;
        int sum = l1.val+l2.val;

        if(sum > 9){
            l1.val=sum-10;

            if(l1.next != null){
                l1.next.val += 1; //核心：把当前的余数直接给下一位加上
            }else{
                l1.next = new ListNode(1);
            }
            l1.next = addTwoNumbers(l1.next,l2.next);
        }else{
            l1.val = sum;
            l1.next = addTwoNumbers(l1.next,l2.next);
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.setNext(new ListNode(2));
//        l1.setNext(new ListNode(4)).setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
//        l2.setNext(new ListNode(6)).setNext(new ListNode(4));

        ListNode listNode = new AddTwoNumbers().addTwoNumbers3(l1, l2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}


