package com.example.demo.leetcode;

import java.util.Stack;

/**
 * zhangyuxiao
 * 2020/9/10 16:58
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack stack = new Stack();
        int popIndex = 0;

        //遍历压栈序列，先压栈，判断栈顶元素登不等于弹出序列头元素
        //相等则弹出，且弹出序列头元素下标后移
        //不相等则继续压栈
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.empty() && stack.peek().equals(popped[popIndex])) {
                stack.pop();
                popIndex++;
            }
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        int[] popped2 = new int[]{4,3,5,1,2};

        System.out.println(new ValidateStackSequences().validateStackSequences(pushed,popped));
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed,popped2));
    }
}
