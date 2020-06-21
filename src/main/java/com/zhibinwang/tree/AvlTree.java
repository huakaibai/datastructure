package com.zhibinwang.tree;

import java.util.Comparator;

/**
 * @author 花开
 * @create 2020-06-17 23:10
 * @desc 自平衡二叉搜索树
 **/
public class AvlTree<E> extends BBST<E> {

    public AvlTree(Comparator comparator) {

        super(comparator);
    }

    public AvlTree() {

        super(null);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AvlNode<>(element, parent);
    }

    @Override
    protected void addAfter(Node<E> node) {
        while ((node = node.parent) != null) {

            if (isBalance(node)) {
                // 是平衡二叉树 更新高度
                updateHeight(node);
            } else {
                /**
                 * 找到高度最低的几点进行平衡
                 * 终止循环
                 */
                reBalance(node);
                break;
            }
        }
    }

    @Override
    protected  void  removeAfter(Node<E> node){
        while ((node = node.parent) != null) {

            if (isBalance(node)) {
                // 是平衡二叉树 更新高度
                updateHeight(node);
            } else {
                /**
                 * 找到高度最低的几点进行平衡
                 * 终止循环
                 */
                reBalance(node);

            }
        }
    }

    private void reBalance(Node<E> grant) {
        /**
         * 传过来的节点grandFather 节点
         */
        // 分别 找到 p n 节点 找到左右子树比较高的节点

        Node<E> parent = ((AvlNode<E>) grant).getTallerNode();
        Node<E> node = ((AvlNode<E>) parent).getTallerNode();
        if (grant.left == parent) {
            if (parent.left == node) {
                // ll 右旋
                // rotateRight(grant);
                rotate(grant, node.left, node, node.right, parent, parent.right, grant, grant.right);
            } else {
                /**
                 * LR 左旋转 右旋转

                 rotateLeft(parent);
                 rotateRight(grant); */
                rotate(grant, parent.left, parent, node.left, node, node.right, grant, grant.right);
            }
        } else {
            if (parent.left == node) {
                // RL  右旋转 左旋转
               /* rotateRight(parent);
                rotateLeft(grant);*/
                rotate(grant, grant.left, grant, node.left, node, node.right, parent, parent.right);
            } else {
                /**
                 * RR 左旋转

                 rotateLeft(grant);*/
                rotate(grant, grant.left, grant, parent.left, parent, node.left, node, node.right);
            }
        }


    }


    @Override
    protected void afterRotate(Node<E> grant, Node<E>  parent, Node<E> node) {

        super.afterRotate(grant, parent, node);

        // 更新高度
        //    updateHeight(node); node的高度没有变
        updateHeight(grant);
        updateHeight(parent);
    }



    /**
     * 统一旋转
     *
     * @param
     * @return
     */
    @Override
    public void rotate(Node<E> r, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        super.rotate(r,a,b,c,d,e,f,g);

        updateHeight(b);
        updateHeight(f);

        updateHeight(d);
    }



    private boolean isBalance(Node<E> node) {
        return ((AvlNode<E>) node).isBalance();
    }

    /**
     * 更新二叉树节点高度
     *
     * @param node
     */
    private void updateHeight(Node<E> node) {
        ((AvlNode<E>) node).updateHeight();
    }

    private static class AvlNode<E> extends Node<E> {
        /**
         * 叶子节点高度为1
         */
        int height = 1;

        public AvlNode(E element, Node<E> parent) {
            super(element, parent);
        }

        /**
         * 获取平衡因子
         *
         * @return
         */
        public int getBalanceFactor() {
            int leftHeight = (left == null ? 0 : ((AvlNode<E>) left).height);
            int rightHeight = (right == null ? 0 : ((AvlNode<E>) right).height);

            return Math.abs(leftHeight - rightHeight);
        }

        /**
         * 判断节点是否平衡
         *
         * @return
         */
        public boolean isBalance() {
            return getBalanceFactor() <= 1;

        }


        public void updateHeight() {
            int leftHeight = (left == null ? 0 : ((AvlNode<E>) left).height);
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }


        public AvlNode<E> getTallerNode() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            if (leftHeight > rightHeight) {
                return (AvlNode<E>) left;
            } else if (leftHeight < rightHeight) {
                return (AvlNode<E>) right;
            } else {
                return (AvlNode<E>) (isLeftNode() ? left : right);
            }

        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }
    }
}
