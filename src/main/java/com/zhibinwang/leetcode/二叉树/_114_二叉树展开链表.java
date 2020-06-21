package com.zhibinwang.leetcode.二叉树;

/**
 * @author 花开
 * @create 2020-06-15 22:15
 * @desc https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 **/
public class _114_二叉树展开链表 {


    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root;
        root.left = null;
        root.right = temp;
        flatten(temp.left);
        flatten(temp.right);
    }
}
