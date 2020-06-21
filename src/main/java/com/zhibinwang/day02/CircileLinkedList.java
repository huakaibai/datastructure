package com.zhibinwang.day02;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.text.PlainDocument;

/**
 * @author 花开
 * @create 2020-06-07 17:07
 * @desc  双向循环链表
 **/
public class CircileLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private Node<E> last;
    private Node<E> current;


    public void add(int index, E elment) {
        rangeCheckForAdd(index);

        //解题思路，先解决中间的，再解决两边的，在考虑list为0的

        // list 中添加最后一个元素
        if (index ==  size){
            Node old = last;
            Node newNode = new Node(old, elment, first);
            last  = newNode;
            if (old == null){
                // list中元素数量为空
                newNode.prev = newNode;
                newNode.next = newNode;
                first = newNode;

            }else {

                old.next = newNode;
              //  old.prev = newNode;
                first.prev = newNode;
                System.out.println(old.next.element);
            }







        }else {

            Node<E> next = indexOf(index);
            Node prev = next.prev;

            Node newNode = new Node(prev, elment, next);
            next.prev = newNode;
            // 说明是0节点
            if (prev == null){
                first = newNode;
            }else {
                prev.next = newNode;

            }




        }


        size++;

    }

    private Node<E> indexOf(int index) {
        rangeCheck(index);
        if (index <= (size >> 1) ){
            //从左边开始位移
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;

        }else{
            Node node = last;
            for (int i = size - 1; i > index;i--){
                node = node.prev;
            }
            return node;
        }


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
        Node<E> node = indexOf(index);
        return remove(node);
    }

    public E remove(Node node) {


      //  Node<E> node = indexOf(index);
        if (size == 1){
            first = null;
            last = null;

        }else {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
            if (node == first){
                first = next;
            }

            if (node == last){
                last = prev;
            }
        }




      /*  if (prev == null){
            first = next;
        }else{
            prev.next = next;
        }*/

   /*     if (next == null){
            last = prev;
        }else{

            next.prev = prev;
        }*/




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
        last = null;
        size = 0;
    }

    public void reset(){
        current = first;
    }

    public E next(){
        if (current == null){
            return null;
        }

        E element = current.element;
        current = current.next;
        return element;
    }

    public E remove(){
        if (current == null){
            return null;
        }
        Node next = current.next;
        E element = remove(current);
        if (size == 0){
            current = null;
        }
        current = next;
        return element;
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ArrayList : [ ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(node);
            node = node.next;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();

    }



    public static class Node<E> {

        E element;
        Node next;
        Node prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder2 = new StringBuilder();
            if (prev != null){
                stringBuilder2.append(prev.element);
            }else {
                stringBuilder2.append("null");
            }

            stringBuilder2.append("_");
            stringBuilder2.append(element);
            stringBuilder2.append("_");

            if (next != null){
                stringBuilder2.append(next.element);
            }else {
                stringBuilder2.append("null");
            }
            return stringBuilder2.toString();
        }
    }


    public static void main(String[] args) {
        CircileLinkedList<Integer> list = new CircileLinkedList<Integer>();
        list.add(10);

        list.add(20);


       list.add( 30);

        list.add( 40);

        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        System.out.println(list);
        list.reset();
        while (!list.isEmpty()){
            list.next();
            list.next();
            Integer remove = list.remove();
            System.out.println(remove);
        }
        System.out.println(list);

  /*     list.remove(0);
        System.out.println(list);
      list.remove(list.size()-1 );

        System.out.println(list);*/
    }
}
