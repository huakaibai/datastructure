package com.zhibinwang.leetcode.stack;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zhibinwang.day02.ArrayList;
import com.zhibinwang.day02.List;

import java.util.Stack;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * @author 花开
 * @create 2020-06-13 11:57
 * @desc https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 **/
public class _150_逆波兰表达式的值 {
    static  List<String> list = new ArrayList<String>();
    static {
        list.add("*");
        list.add("-");
        list.add("+");
        list.add("/");
    }
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (list.contains(token)){
                String b = stack.pop();
                String a = stack.pop();
                int calculate = calculate(a, b,token);
                stack.push(String.valueOf(calculate));
            }else {
                stack.push(token);
            }

        }

        return Integer.valueOf(stack.pop());
    }


    public int  calculate(String a,String b,String toekn){
        Integer intA = Integer.valueOf(a);
        Integer intB = Integer.valueOf(b);

        switch (toekn){
            case  "+":
                return (intA + intB);
            case "-":
                return (intA - intB);
            case "*":
                return (intA * intB);
            case "/":
                return (intA / intB);
        }
        return 0;
    }

}
