package com.zhibinwang.tree;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zhibinwang.tree.printer.BinaryTreeInfo;
import com.zhibinwang.tree.printer.LevelOrderPrinter;
import javafx.scene.transform.Rotate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 花开
 * @create 2020-06-14 9:41
 * @desc 二叉搜索树
 **/
public class BinarySearchTree<E>  extends  BinaryTree {


    /**
     * 比较器
     */
    protected Comparator comparator;





    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }


    protected  void addAfter(Node<E> eNode){};
    protected  void removeAfter(Node<E> Node){};

    protected  Node<E> createNode(E element ,Node<E> parent){
        return new Node<>(element,parent);
    }

    public void add(E element){
        if (root == null){
            root = createNode(element,null);
            size++;
            addAfter(root);
            return;
        }
        Node<E> node = root;
        Node<E> parent = root;
        int compare = 0;
        while (node != null){
            parent = node;
            compare = compare( element,node.element);

            if (compare > 0 ){
                // 右子树添加节点
                node = node.right;

            }else if (compare < 0){
                node = node.left;
            }else {
                //两个值比较相等
                node.element = element;
                addAfter(node);
                return;
            }

        }
      Node<E> newNode =   createNode(element,parent);
        if (compare > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        addAfter(newNode);
        size++;


    }

    public void remove(E element){

        Node<E> node = node(element);
        remove(node);
    }

    private void remove(Node<E> node) {
        if (node == null) return;

        Node<E> successor = node;
        if (node.hasTwoNode()){
            /**
             * 删除的是度为2的节点，找到前序节点或者后续节点
             */
           //  successor = successor(node);
            successor = predecessor(node);
            /**
             * 直接覆盖原节点的值
             */
            node.element = successor.element;
        }
        Node<E> replaceNode =  successor.left != null ? successor.left:successor.right;


        if (replaceNode != null){
            if (successor.parent == null){
                root = replaceNode;
                replaceNode.parent = null;
            }else {
                replaceNode.parent = successor.parent;
                //度为1 的节点
                if (successor.parent.left == successor){
                    successor.parent.left = replaceNode;
                }else {
                    successor.parent.right = replaceNode;
                }
            }

        }else {
            // 度为0的节点
            if (successor.parent == null){
                root = null;

            }else {
                //度为0 的节点
                if (successor.parent.left == successor){
                    successor.parent.left = null;
                }else {
                    successor.parent.right = null;
                }
            }

        }

        removeAfter(node);

    }

    private Node<E> node(E element) {
        Node<E> result = root;
        while (result != null){
            int compare = compare(element, result.element);
            if (compare > 0){
                result = result.right;
            }else if (compare < 0){
                result = result.left;
            }else{
                return result;
            }


        }
        return null;
    }

    public boolean contains(E element){
        return node(element) != null;
    }







    private int compare(E e1,E e2){
        if (comparator != null){
            return comparator.compare(e1,e2);
        }

       return  ((Comparable)e1).compareTo(e2);

    }







}
