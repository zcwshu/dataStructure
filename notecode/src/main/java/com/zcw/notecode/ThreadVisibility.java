package com.zcw.notecode;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:04 2020/8/13
 */

//volatile作用
public class ThreadVisibility {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(running){
                //do sth
            }
            System.out.println("end");
        },"server").start();

        Thread.sleep(1000);
        running = false;
    }
}
