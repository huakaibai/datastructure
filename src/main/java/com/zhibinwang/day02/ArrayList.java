package com.zhibinwang.day02;

/**
 * @author 花开
 * @create 2020-06-06 22:00
 * @desc 手工实现动态数组
 **/
public class ArrayList<E> extends  AbstractList<E> {




    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        elements = (E[]) new Object[capacity];

    }


    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }





    /**
     * 往index位置添加元素
     *
     * @param index
     * @param elment
     */
    public void add(int index, E elment) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size-1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = elment;
        size++;
    }



    /**
     * 进行扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        if (elements.length < capacity) {
            //扩容1.5倍
            capacity = elements.length + (elements.length >> 1);

            E[] newElements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }


            elements = newElements;

        }
    }

    /**
     * 返回位置相对应的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }


    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {

        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }


    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        // 释放内存对象
        elements[--size] = null;
        return old;
    }


    /**
     * 查看元素位置
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }


        return -1;
    }

    /**
     * 清除元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ArrayList : [ ");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);
        arrayList.add(60);
        arrayList.add(70);
        arrayList.add(80);
        arrayList.add(90);
        arrayList.add(100);
        arrayList.add(101);
        arrayList.add(102);

      //  arrayList.add(30,105);
        arrayList.remove(0);
        arrayList.add(arrayList.size()-1,1);
        System.out.println(arrayList);

        System.out.println(arrayList.get(arrayList.size() - 1));
    }
}
