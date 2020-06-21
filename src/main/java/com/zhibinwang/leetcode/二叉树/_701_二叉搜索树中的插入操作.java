package com.zhibinwang.leetcode.二叉树;

/**
 * @author 花开
 * @create 2020-06-20 22:49
 * @desc https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 **/
public class _701_二叉搜索树中的插入操作 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null){
            root = node;
            return root;
        }
        TreeNode temp = root;

        TreeNode parent = null;
        while (temp != null) {
            parent = temp;
            if (val < temp.val) {
                temp = temp.left;

            } else {
                temp = temp.right;
            }


        }

        if (val < parent.val) {
            parent.left = node;

        } else {
            parent.right = node;
        }

        return root;

    }
}
