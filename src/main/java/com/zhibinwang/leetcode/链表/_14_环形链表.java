package com.zhibinwang.leetcode.链表;

/**
 * @author 花开
 * @create 2020-06-07 18:36
 * @desc https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针的思想
 **/
public class _14_环形链表 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;

        }

        return false;

    }
}
