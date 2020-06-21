package com.zhibinwang.leetcode.链表;

/**
 * @author 花开
 * @create 2020-06-07 18:05
 * @desc https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class _206_反转链表 {

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode nowNode = reverseList1(head.next);
        head.next.next = head;
       head.next = null;
        return nowNode;


    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;


        }

        return newNode;

    }
}
