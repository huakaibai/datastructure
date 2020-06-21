package com.zhibinwang.day02;

/**
 * @author 花开
 * @create 2020-06-07 17:08
 * @desc 抽象列表
 **/
public abstract class AbstractList<E> implements List<E> {

    /**
     * list 元素数量
     */
    protected int size;


    /**
     * 返回元素数量
     *
     * @return
     */
    public int size() {
        return size;
    }


    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {

        return size == 0 ? true : false;
    }


    /**
     * 判断集合是否包含某种元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {

        return indexOf(element) > -1 ? true : false;
    }


    /**
     * 添加元素到最后
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }


    /**
     * 检测index是否合法
     *
     * @param index
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " size:" + size);
        }
    }


    protected void rangeCheck(int index) {
        if (index < 0 || index > size-1 ) {
            throw new IndexOutOfBoundsException("Index: " + index + " size:" + size);
        }
    }

}
