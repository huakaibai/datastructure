package com.zhibinwang.day02.singlelist;

import com.zhibinwang.day02.AbstractList;
import com.zhibinwang.day02.List;

/**
 * @author 花开
 * @create 2020-06-07 17:07
 * @desc  它菜是单循环链表
 **/
public class LSingleLinnkedList<E> extends AbstractList<E> {

    private Node<E> first;


    public void add(int index, E elment) {
        rangeCheckForAdd(index);
        if (index == 0) {
            Node<E> node = new Node<E>(elment, first);

            if (first == null){
                //说明添加的是第一个元素
                first = node;
                first.next = node;
            } else{
                Node<E> lastNode = indexOf(size - 1);
                first = node;
                lastNode.next = node;
            }
        } else {
            // 找出插入位置的前一个节点
            Node<E> preNode = indexOf(index - 1);
            Node<E> node = new Node<E>(elment, preNode.next);
            preNode.next = node;
            System.out.println(preNode.next .element);
        }
        size++;

    }

    private Node<E> indexOf(int index) {
        rangeCheck(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        return indexOf(index).element;
    }

    public E set(int index, E element) {
        Node<E> oldNode = indexOf(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    public E remove(int index) {
        rangeCheck(index);
        Node node = first;
        if (index == 0) {
            if (size == 1){
                first = null;
            }else{
                Node<E> lastNode = indexOf(size - 1);
                lastNode.next = first.next;
                first = first.next;
            }




        } else {
            Node<E> preNode = indexOf(index - 1);
            node = preNode.next;
            preNode.next = node.next;
        }
        size--;
        return (E) node.element;
    }

    public int indexOf(E element) {
        if (element == null) {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }


        return -1;
    }

    public void clear() {

        first = null;
        size = 0;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ArrayList : [ ");
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(node.element);
            node = node.next;
            if (i == size -1){
                stringBuilder.append(" , ");
                stringBuilder.append(node.element);
            }
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();

    }


    public static class Node<E> {

        E element;
        Node next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new LSingleLinnkedList<Integer>();
        list.add(10);
        System.out.println(list);
        list.add(20);
        System.out.println(list);
        list.add(0, 30);
        System.out.println(list);
        list.add(50);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(list.size()-1 );
        list.remove(list.size()-1 );
        list.remove(list.size()-1 );
        System.out.println(list);
    }
}
