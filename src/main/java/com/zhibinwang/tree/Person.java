package com.zhibinwang.tree;

/**
 * @author 花开
 * @create 2020-06-14 10:01
 * @desc
 **/
public class Person implements  Comparable<Person> {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion_age="+age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
