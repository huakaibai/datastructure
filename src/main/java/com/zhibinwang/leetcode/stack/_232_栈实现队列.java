package com.zhibinwang.leetcode.stack;

import java.util.Stack;

/**
 * @author 花开
 * @create 2020-06-14 17:14
 * @desc 232. 用栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 **/
public class _232_栈实现队列 {

    private Stack<Integer> inStack = new Stack<>();

    private Stack<Integer> outStack = new Stack<>();


    /** Push element x to the back of queue. */
    public void push(int x) {

        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outStack.isEmpty()){
            return outStack.pop();
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!outStack.isEmpty()){
            return outStack.peek();
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        return inStack.isEmpty() && outStack.isEmpty();
    }
}
