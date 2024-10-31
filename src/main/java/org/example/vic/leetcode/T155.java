package org.example.vic.leetcode;

import java.util.Objects;
import java.util.Stack;

public class T155 {

}


class MinStack {
    Stack<Integer> stack = new Stack<>();

    Stack<Integer> minStack = new Stack<>();

    /**
     * 初始化堆栈对象
     */
    public MinStack() {

    }

    /**
     * 元素val推入堆栈
     *
     * @param val 输入
     */
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    /**
     * 删除堆栈顶部的元素
     */
    public void pop() {
        if (!minStack.isEmpty() && Objects.equals(minStack.peek(), stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    /**
     * 获取堆栈顶部的元素
     *
     * @return 元素值
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取堆栈中的最小元素
     *
     * @return 最小元素值
     */
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
