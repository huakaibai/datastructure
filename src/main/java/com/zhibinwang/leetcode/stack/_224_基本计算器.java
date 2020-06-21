package com.zhibinwang.leetcode.stack;

import java.util.List;
import java.util.Stack;

/**
 * @author 花开
 * @create 2020-06-13 12:12
 * @desc https://leetcode-cn.com/problems/basic-calculator/
 **/
public class _224_基本计算器 {

    public int calculate(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(')
            {
                stack.push(c);
            }else if ( c == ' '){
                continue;
            }else if (c == ')'){
                int temp = 0;

                while (!stack.isEmpty()){
                    Character peek = stack.peek();
                    if ( peek == '('){
                        stack.pop();
                        break;
                    }

                    Character b = stack.pop();
                    Character token = stack.pop();
                    Character a = stack.pop();
                    int calculate = calculate(a, b, token);
                    temp += calculate;
                }

               // stack.push();
            }
        }
        return 0 ;
    }


    private int  calculate(Character a,Character b,Character toekn){
        Integer intA = Integer.valueOf(a);
        Integer intB = Integer.valueOf(b);

        switch (toekn){
            case  '+':
                return (intA + intB);
            case '-':
                return (intA - intB);

        }
        return 0;
    }
}
