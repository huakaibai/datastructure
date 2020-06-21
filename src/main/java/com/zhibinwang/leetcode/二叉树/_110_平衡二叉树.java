package com.zhibinwang.leetcode.二叉树;

import java.awt.*;

/**
 * @author 花开
 * @create 2020-06-19 0:50
 * @desc https://leetcode-cn.com/problems/balanced-binary-tree/
 **/
public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if (node == null)
            return 0;
        return 1+ Math.max(height(node.left),height(node.right));
    }
}
