package com.zhibinwang.leetcode.二叉树;

/**
 * @author 花开
 * @create 2020-06-20 22:46
 * @desc https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 **/
public class _700_二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }

        }
        return null;

    }
}
