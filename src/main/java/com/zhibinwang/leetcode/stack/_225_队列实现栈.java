package com.zhibinwang.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 花开
 * @create 2020-06-14 17:25
 * @desc https://leetcode-cn.com/problems/implement-stack-using-queues/
 **/
public class _225_队列实现栈 {

    private Queue<Integer> queue = new LinkedList<>();
    // 只向头
    int tail;

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        tail = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.size() == 1){
            return queue.poll();
        }
        for (int i = 0; i < queue.size() - 2;i++){
            queue.offer(queue.poll());
        }


        tail = queue.poll();
        int result = queue.poll();
        queue.offer(tail);
        return result;





    }

    /** Get the top element. */
    public int top() {

        return tail;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return queue.isEmpty();
    }
}
