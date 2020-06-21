package com.zhibinwang.leetcode.二叉树;

import com.zhibinwang.day02.CircileLinkedList;

/**
 * @author 花开
 * @create 2020-06-20 23:01
 * @desc https://leetcode-cn.com/problems/validate-binary-search-tree/
 **/
public class _98_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
/*        boolean left = false;
        boolean right = false;
        if (root.left == null || root.left.val < root.val){
            left = true;
        }

        if (root.right == null || root.right.val > root.val){
            right = true;
        }

        boolean check = left && right;

        return  check&&isValidBST(root.left) && isValidBST(root.right);*/
        return recurse(root,null,null);

    }


    private boolean recurse(TreeNode node,Integer lower,Integer upper){


        if (node == null)
            return true;
        int val = node.val;
        if (lower != null && val < lower ) return false;
        if (upper != null && val > upper ) return false;
        if (!recurse(node.left,lower,node.val)) return false;
        if (!recurse(node.right,node.val,upper)) return false;
        return true;
    }
}
