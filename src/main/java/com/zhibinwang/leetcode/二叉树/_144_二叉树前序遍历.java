package com.zhibinwang.leetcode.二叉树;

import com.zhibinwang.day02.CircileLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 花开
 * @create 2020-06-15 21:33
 * @desc https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 **/
public class _144_二叉树前序遍历 {

    /**
     * 前序遍历 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return  list;
        }


        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }


        }
        return list;

    }

    /**
     * 中序遍历 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return  list;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null){
            stack.push(node);
            node.left = node;
        }

        while (!stack.isEmpty()){
            node  = stack.pop();
            list.add(node.val);
            node = node.right;
        }

     /*   if (node != null){
            stack.push(node);
            node.left = node;
        }else {
            while (!stack.isEmpty()){
                TreeNode pop = stack.pop();
            }
        }*/

        return list;


    }
}
