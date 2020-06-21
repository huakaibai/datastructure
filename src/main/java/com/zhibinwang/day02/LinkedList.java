package com.zhibinwang.day02;

/**
 * @author 花开
 * @create 2020-06-07 17:07
 * @desc  双向链表
 **/
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private Node<E> last;


    public void add(int index, E elment) {
        rangeCheckForAdd(index);

        //解题思路，先解决中间的，再解决两边的，在考虑list为0的

        // list 中添加最后一个元素
        if (index ==  size){
            Node old = last;
            Node newNode = new Node(old, elment, null);
            last  = newNode;
            if (old == null){
                // list中元素数量为空
                first = newNode;
            }else {
                old.next = newNode;
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

        Node prev = node.prev;
        Node next = node.next;



        if (prev == null){
            first = next;
        }else{
            prev.next = next;
        }

        if (next == null){
            last = prev;
        }else{

            next.prev = node;
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
        last = null;
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
            StringBuilder stringBuilder = new StringBuilder();
            if (next != null){
                stringBuilder.append(next.element);
            }else {
                stringBuilder.append("null");
            }
            stringBuilder.append("_");
            stringBuilder.append(element);
            stringBuilder.append("_");
            if (prev != null){
                stringBuilder.append(prev.element);
            }else {
                stringBuilder.append("null");
            }

            return stringBuilder.toString();
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
   list.add(1, 30);
      list.add(50);
      // list.remove(0);
      list.remove(list.size() );

        System.out.println(list);
    }
}
