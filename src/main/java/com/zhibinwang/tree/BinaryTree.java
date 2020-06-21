package com.zhibinwang.tree;

import com.zhibinwang.tree.printer.BinaryTreeInfo;
import sun.reflect.generics.visitor.Visitor;

import java.nio.file.NotDirectoryException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 花开
 * @create 2020-06-17 22:57
 * @desc 二叉树
 **/
public class BinaryTree<E> implements BinaryTreeInfo {

    /**
     * 节点数量
     */
    protected int size;
    /**
     * 父类节点
     */
    protected Node<E> root;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {

        preOrderTraversal(this.root);
    }


    private void preOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {

        inOrderTraversal(this.root);
    }


    private void inOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }

        preOrderTraversal(node.left);
        System.out.println(node.element);
        preOrderTraversal(node.right);
    }


    /**
     * 后续遍历
     */
    public void postOrder() {

        postOrderTraversal(this.root);
    }


    private void postOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);
        System.out.println(node.element);
    }


    /**
     * 层序遍历
     */
    public void leverOrder(Visitor<E> visitor) {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.execute(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    /**
     * 层序遍历求二叉树的高度
     *
     * @return
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        int height = 0;
        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
            levelSize--;
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }


    /**
     * 判断是否是完全二叉树
     *
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            if (isLeaf && !node.isLeafNode()) {
                return false;
            }


            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                isLeaf = true;
            }

        }

        return true;
    }

    /**
     * 递归求二叉树的高度
     *
     * @return
     */
    public int height1() {
        return height(root);
    }


    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));

    }


    /**
     * 前驱节点
     *
     * @param node
     * @return
     */
    public Node<E> predecessor(Node node) {
        if (node == null){
            return node;
        }


        if (node.left != null) {
            Node<E> left = node.left;
            while (left.right != null) {
                left = left.right;
            }
            return left;
        }

        if (node.parent != null) {
            Node<E> parent = node.parent;
            while (parent != null) {
                if (parent.parent.right == parent) {
                    return parent.parent;
                }
                parent = parent.parent;
            }

        }
        return null;
    }


    /**
     * 后驱节点
     *
     * @param node
     * @return
     */
    public Node<E> successor(Node<E> node) {
        if (node == null){
            return node;
        }

        if (node.right != null) {
            Node<E> right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        if (node.parent != null) {
            Node<E> parent = node.parent;
            while (parent != null) {
                if (parent.parent.left == parent) {
                    return parent.parent;
                }
                parent = parent.parent;
            }

        }
        return null;

    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node);
    }


    public static interface Visitor<E> {
        void execute(E element);
    }

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeafNode() {
            return left == null && right == null;
        }

        public boolean hasTwoNode() {
            return left != null && right != null;
        }


        public  boolean isLeftNode(){
            return parent != null && parent.left == this;
        }

        public  boolean isRightNode(){
            return parent != null && parent.right == this;
        }

        public Node<E> sibling(){
            if (parent != null && this == parent.left){
                return  parent.right;
            }
            if (parent != null && this == parent.right){
                return  parent.left;
            }

            return null;
        }
    }
}
