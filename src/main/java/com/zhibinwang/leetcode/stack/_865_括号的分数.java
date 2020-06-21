package com.zhibinwang.leetcode.stack;

import java.util.Stack;

/**
 * @author 花开
 * @create 2020-06-13 10:38
 * @desc https://leetcode-cn.com/problems/score-of-parentheses/
 **/
public class _865_括号的分数 {

    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if (c == '('){
                stack.push(0);
            }else{
               /* Character pop = (Character) stack.pop();
                if (pop == '('){
                    stack.push('1');
                }else{

                }*/
               int temp = 0;
               while (!stack.isEmpty() ){
                   int peek = stack.pop();

                   if (peek == 0) {

                       if (temp != 0){
                           stack.push(2 * temp);

                       }else{
                           stack.push(1);
                       }
                       break;
                   }else {
                     temp+= peek;
                   }
               }
            }
        }
        int result = 0;
        while (!stack.isEmpty() ){
            int pop = (Integer) stack.pop();
            result += pop;
        }
        return result;

    }

    public static void main(String[] args) {
        scoreOfParentheses("(())");
    }
}
