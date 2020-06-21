package com.zhibinwang.tree;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author 花开
 * @create 2020-06-21 22:36
 * @desc 红黑树
 **/
public class RBTree<E> extends BBST<E> {

    private static boolean RED = false;

    private static boolean BLACK = true;

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RbNode<>(element, parent);
    }


    @Override
    protected void addAfter(Node<E> node) {

        /**
         * 如果添加的是根节点，将节点染黑，退出
         */
        Node<E> parent = node.parent;
        if (parent == null) {
            black(node);
            return;
        }

        /**
         * 如果父节点是黑色的不需要做任何操作
         */
        if (isBLACK(parent)) {
            return;
        }

        // 取到叔父节点
        /**
         * 只能添加到红色节点
         */
        Node<E> uncle = parent.sibling();
        Node<E> grand = parent.parent;
        if (isRed(uncle)) {
            /**
             * 叔父节点是红色的情况 会出现上溢
             * 将他的叔叔和父亲全部染黑，
             *
             * 祖父节点染红
             * 将祖父节点递归添加
             */
            black(parent);
            black(uncle);

            addAfter(red(grand));

        } else {

            if (parent.isLeftNode()) {
                red(grand);
                if (node.isLeftNode()) {
                    //LL 右旋转父类
                    black(parent);
                    //  red(grand);
                    // rotateRight(grand);
                } else {
                    // lr
                    black(node);
                    //    red(grand);
                    rotateLeft(parent);
                    //   rotateRight(grand);
                }
                rotateRight(grand);

            } else {
                red(grand);
                if (node.isLeftNode()) {
                    //rl

                    black(node);
                    //   red(grand);
                    rotateRight(parent);
                    //  rotateLeft(grand);

                } else {
                    // rr
                    black(parent);
                    //   red(grand);
                    //   rotateLeft(grand);
                }
                rotateLeft(grand);
            }

        }


    }

    @Override
    protected void removeAfter(Node<E> Node) {
        super.removeAfter(Node);
    }

    public boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    public boolean isBLACK(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    public boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RbNode<E>) node).color;
    }


    public RbNode<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    public RbNode<E> red(Node<E> node) {
        return color(node, RED);
    }

    public RbNode<E> color(Node<E> node, boolean color) {
        ((RbNode<E>) node).color = color;
        return ((RbNode<E>) node);
    }


    private static class RbNode<E> extends Node<E> {
        // 默认添加的节点时红色
        private boolean color = RED;

        public RbNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {

            StringBuilder stringBuilder = new StringBuilder();
            if (color == RED){
                stringBuilder.append("R_");
            }
            stringBuilder.append(element);
            return stringBuilder.toString();
        }
    }


}
