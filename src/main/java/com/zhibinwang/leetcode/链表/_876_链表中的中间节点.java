package com.zhibinwang.leetcode.链表;

/**
 * @author 花开
 * @create 2020-06-11 23:26
 * @desc https://leetcode-cn.com/problems/middle-of-the-linked-list/
 **/
public class _876_链表中的中间节点 {

    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int n = 0;
        while (node != null){
            node = node.next;
            n++;
        }
        node = head;
        int middle = n / 2 == 0 ? n/2 +1 : n/2;
        int j = 0;
        while (node != null){
            if (j == middle){
                return node;
            }

            node = node.next;
            j++;
        }
        return null;
    }
}
