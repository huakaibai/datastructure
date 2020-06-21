package com.zhibinwang.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 花开
 * @create 2020-06-13 10:27
 * @desc https://leetcode-cn.com/problems/valid-parentheses/
 **/
public class _20_有效的括号 {

  static   Map<Character, Character> map = new HashMap<Character, Character>();
    {
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
    }
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                // 栈为空返回fasle;
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (!map.get(pop).equals(c)){
                    return false;
                }
            }
        }

        if (!stack.isEmpty()){
            return false;
        }

        return true;
    }

}
