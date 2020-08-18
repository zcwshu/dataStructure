package com.zcw.test;

/**
 * @Author: AndrewBar
 * @Date: Created in 18:27 2020/7/22
 */
public class Test {
    public static void main(String[] args) {

        new Dog();
    }
}
class Animal{
    public Animal() {
        System.out.println("a");
    }
    static {
        System.out.println("sa");
    }
}
class Dog extends Animal{
    public Dog() {
        System.out.println("d");
    }
    static {
        System.out.println("sd");
    }
}
