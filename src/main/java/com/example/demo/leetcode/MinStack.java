package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * zhangyuxiao
 * 2020/11/4 09:52
 */
public class MinStack {

    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
          MinStack obj = new MinStack();
          obj.push(2);
          obj.push(3);
          obj.push(1);
          obj.push(4);
        System.out.println(obj.min());
          obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
        System.out.println("===========");

        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0));

    }
}
