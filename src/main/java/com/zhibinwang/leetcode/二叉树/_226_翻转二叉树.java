package com.zhibinwang.leetcode.二叉树;

import javafx.scene.transform.Rotate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 花开
 * @create 2020-06-15 21:19
 * @desc https://leetcode-cn.com/problems/invert-binary-tree/
 **/
public class _226_翻转二叉树 {


    /**
     * 反转二叉树 翻转二叉树的本质是遍历节点 前序遍历
     * @param root
     * @return
     */
/*    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }*/

    /**
     * 中序遍历 翻转
     * @param root
     * @return
     */
  /*  public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;


        invertTree(root.left);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        return root;
    }*/


    /**
     * 后续遍历
     * @param root
     * @return
     */
/*    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;


        invertTree(root.left);

        invertTree(root.right);


        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }*/

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }

}
