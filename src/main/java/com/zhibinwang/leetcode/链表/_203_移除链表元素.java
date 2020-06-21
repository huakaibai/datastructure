package com.zhibinwang.leetcode.链表;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import javax.xml.transform.Templates;

/**
 * @author 花开
 * @create 2020-06-11 22:28
 * @desc https://leetcode-cn.com/problems/remove-linked-list-elements/
 **/
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode listNode = head;
        ListNode temp = null;
        while (listNode  != null){

            if (listNode.val == val){
               if (head == listNode){
                   head = head.next;
                   listNode = head;
               }else {
                   temp.next = listNode.next;

                   listNode = listNode.next;
               }
            }else {
                temp = listNode;
                listNode = listNode.next;
            }




        }
        return  head;
    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
