package com.zhibinwang.tree;

import java.util.Comparator;

/**
 * @author 花开
 * @create 2020-06-21 22:19
 * @desc 自平衡二叉树
 **/
public class BBST<E> extends BinarySearchTree<E> {

    public BBST(Comparator comparator) {

        super(comparator);
    }

    public BBST() {

        super(null);
    }
    /**
     * 左旋转
     *
     * @param grant
     */

    protected void rotateLeft(Node<E> grant) {
        Node<E>  parent = grant.right;
        if (parent == grant.right) {
            System.out.println("right");
        } else {
            System.out.println("left");
        }


        Node<E> node = parent.left;
        parent.left = grant;
        grant.right = node;

        afterRotate((Node<E>) grant, parent, (Node<E>) node);

    }

    /**
     * 右旋转
     *
     * @param
     */
    protected void rotateRight(Node<E> grant) {
      Node<E>   parent = (grant).left;
        if (parent == grant.left) {
            System.out.println("right-left");
        } else {
            System.out.println("right-right");
        }

        Node<E> node = parent.right;
        grant.left = node;
        parent.right = grant;

        //更新父类
        afterRotate(grant, parent, node);


    }


    protected void afterRotate(Node<E> grant, Node<E>  parent, Node<E> node) {

        parent.parent = grant.parent;
        if (grant.isLeftNode()) {
            grant.parent.left = parent;
        } else if (grant.isRightNode()) {
            grant.parent.right = parent;
        } else {
            root = parent;
        }


        //更新父类
        if (node != null) {
            node.parent = grant;
        }

        grant.parent = parent;


    }

    /**
     * 统一旋转
     *
     * @param
     * @return
     */
    public void rotate(Node<E> r, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        d.parent = r.parent;


        // 让d 成为子树的根节点
        if (r.isLeftNode()) {
            r.parent.left = d;
        } else if (r.isRightNode()) {
            r.parent.right = d;
        } else {
            root = d;
        }


        if (a != null) {
            a.parent = b;

        }
        if (c != null) {
            c.parent = b;

        }
        b.left = a;
        b.right = c;
        b.parent = d;
        if (e != null) {
            e.parent = f;

        }
        if (g != null) {
            g.parent = f;

        }

        f.left = e;
        f.right = g;
        f.parent = d;

        d.left = b;
        d.right = f;


    }

}
