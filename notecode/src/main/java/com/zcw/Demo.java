package com.zcw;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:34 2020/8/11
 */
public class Demo {
    public static void main(String[] args) {
        new Thread(()->{

        },"my thread name").start();
    }

    //凡是带了native关键字的,说明java的作用范围达不到,调本地c语言的库
    //会进入本地方法栈
    //调用本地方法本地接口JNI  (Java Native Interface)
    //JNI作用 : 扩展java的使用,融合不同的编程语言为java所用!  最初 C C++
    //内存中开辟一块标记区域,加载本地方法库中的方法通过JNI

    //java程序驱动打印机 ,管理系统,Robot,掌握即可,企业级应用较为少见
    public native void hello();

    //调用其他接口 : Socket , webservice , http
}
