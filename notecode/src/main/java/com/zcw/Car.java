package com.zcw;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:34 2020/8/11
 */
public class Car {
    public int age;

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        Class<? extends Car> car1Class = car1.getClass();

        ClassLoader classLoader = car1Class.getClassLoader();

        System.out.println(classLoader);//应用程序加载器
        System.out.println(classLoader.getParent());//扩展类加载器   /jre/lib/ext
        System.out.println(classLoader.getParent().getParent());//获取不到/不存在     rt.jar
    }
}
