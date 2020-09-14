package com.example.demo.leetcode;

import java.util.Stack;

/**
 * zhangyuxiao
 * 2020/9/10 15:59
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
 */
class CQueue {
    private Stack pushStack;
    private Stack popStack;

    public CQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    public void push(int value) {
        pushStack.push(value);
    }

    public int pop() {
        if (pushStack.empty() && popStack.empty()) {
            return -1;
        }
        //由于是从pushStck往popStack赋值，所以popStack的内容肯定比pushStack剩余的内容老
        // 当popStack不为空时，一直从popstack取即可，空了再从pushStack进货
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }

        return (int) popStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
