package com.zhibinwang.day1;

import sun.management.Sensor;

/**
 * @author 花开
 * @create 2020-06-06 17:13
 * @desc 斐波那契数据
 * 0 1 1 2 3 5 8
 * 所求数字位前一位和前两位数字之和
 **/
public class Demo1 {

    /**
     * 递归求第n位的值，时间复杂度 O(2^n)
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }


        return fib1(n - 1) + fib1(n - 2);
    }


    /**
     * 循环求第n位的值，时间复杂度位O(n)
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++){
            int sum = first + second;
            first = second;
            second = sum;

        }

        return second;
    }


    public static void main(String[] args) {
        System.out.println(fib2(64));
        System.out.println(fib1(64));
    }
}
