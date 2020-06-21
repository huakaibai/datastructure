package com.zhibinwang.leetcode.链表;

/**
 * @author 花开
 * @create 2020-06-11 23:15
 * @desc https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 **/
public class _83_删除链表重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = head;
        while (listNode != null && listNode.next != null){
            if (listNode.val == listNode.next.val){
                listNode.next = listNode.next.next;
            }else{
                listNode = listNode.next;
            }

        }

        return head;
    }
}
