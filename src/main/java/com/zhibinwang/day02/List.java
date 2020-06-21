package com.zhibinwang.day02;

/**
 * @author 花开
 * @create 2020-06-07 17:07
 * @desc 链表接口
 **/
public interface List<E> {




    /**
     * 返回元素数量
     *
     * @return
     */
     int size();


    /**
     * 判断数组是否为空
     *
     * @return
     */
     boolean isEmpty();


    /**
     * 判断集合是否包含某种元素
     *
     * @param element
     * @return
     */
     boolean contains(E element);


    /**
     * 添加元素到最后
     *
     * @param element
     */
     void add(E element) ;


    /**
     * 往index位置添加元素
     *
     * @param index
     * @param elment
     */
     void add(int index, E elment);




    /**
     * 返回位置相对应的元素
     *
     * @param index
     * @return
     */
    public E get(int index) ;


    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return
     */
     E set(int index, E element) ;


    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
     E remove(int index);

    /**
     * 查看元素位置
     *
     * @param element
     * @return
     */
     int indexOf(E element);

    /**
     * 清除元素
     */
     void clear() ;


}
