package com.zhibinwang.leetcode.二叉树;

import com.zhibinwang.day02.CircileLinkedList;

import javax.xml.bind.ValidationEvent;
import java.awt.*;

/**
 * @author 花开
 * @create 2020-06-19 23:43
 * @desc https://leetcode-cn.com/problems/delete-node-in-a-bst/
 **/
public class _450_删除二叉搜索树的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }
        TreeNode node = root;
        TreeNode parent = root;
        while (node != null && node.val != key) {
            if (key > node.val) {
                node = node.right;

            } else if (key < node.val) {
                node = node.left;

            } else {
                break;
            }
            if (node != null &&node.val != key){
                parent = node;
            }
        }
        if (node == null) {
            return root;
        }
        TreeNode preNode = node;
        if (node.left != null && node.right != null) {
            preNode = preNode(node);

            node.val = preNode.val;
            TreeNode treeNode = preNode.left != null? preNode.left:preNode.right;
            if (node.left == preNode){
                node.left = treeNode;
            }else {
                node.right = treeNode;
            }
            return root;
        }


        TreeNode treeNode = preNode.left != null? preNode.left:preNode.right;

        if (parent.left == preNode){
            parent.left = treeNode;
        } else if (parent.right == preNode){
            parent.right = treeNode;
        }else{
            root = treeNode;
        }
        return root;






    }

    private TreeNode preNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode left = node.right;
        while (left != null && left.left != null) {
            left = left.left;
        }
        return left;
    }
    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = null;
            root.right = new TreeNode(2);

        _450_删除二叉搜索树的节点 a = new _450_删除二叉搜索树的节点();

        a.deleteNode(root,2);


    }
}
