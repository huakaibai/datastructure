package com.zhibinwang.queue;

/**
 * @author 花开
 * @create 2020-06-12 23:10
 * @desc 循环双端队列
 **/
public class CircleDeQueue<E> {

    private int size;

    private int front;

    private E[] elements;

    public static final int DEFAULT_CAPACITY = 10;

    public CircleDeQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size < 1;
    }

    public void clear() {
        for (int i = 0; i < size;i++){
            elements[indexOf(i)] = null;
        }
        front = 0;
        size = 0;

    }

    /**
     * 入队尾
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[indexOf(size)] = element;
        size++;
    }

    /**
     * 从对头出对
     * @return
     */
    public E deQueueFront() {
        E element = elements[front];
        elements[front] = null;
        front = indexOf(1);
        size--;
        return element;
    }

    /**
     * 入对头
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        elements[indexOf(-1)] = element;
        front = indexOf(-1);
        size++;
    }

    /**
     * 出队尾
     * @return
     */
    public E deQueueRear() {
        E element = elements[indexOf(size-1)];
        elements[indexOf(size-1)] = null;

        size--;
        return element;
    }



    public E front() {

        return elements[front];
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Dequeue : [ ");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();

    }

    /**
     * 获取真实位置
     *
     * @param index
     * @return
     */
    private int indexOf(int index) {

        index += front;
        if (index < 0)
            return index + elements.length;

        return index - (index >= elements.length ? elements.length : 0);
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
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[indexOf(i)];
            }


            elements = newElements;
            front = 0;

        }
    }
}
