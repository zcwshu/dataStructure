package com.zcw.note;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: AndrewBar
 * @Date: Created in 10:44 2020/8/10
 */
public class LockTest {
    private Lock lock = new ReentrantLock();

    public void lockTest(Thread thread){
        lock.lock();//获取锁
        try {
            System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
            Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
        } catch (Exception e) {
            System.out.println("线程"+thread.getName() + "发生了异常释放锁");
        }finally {
            System.out.println("线程"+thread.getName() + "执行完毕释放锁");
            lock.unlock(); //释放锁
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        //声明一个线程一
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.tryLockTest(Thread.currentThread());
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.tryLockTest(Thread.currentThread());
            }
        },"thread2");
        // 启动2个线程
        thread2.start();
        thread1.start();
    }
    public void tryLockTest(Thread thread) {
        if(lock.tryLock()) { //尝试获取锁
            try {
                System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
                Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
            } catch (Exception e) {
                System.out.println("线程"+thread.getName() + "发生了异常释放锁");
            }finally {
                System.out.println("线程"+thread.getName() + "执行完毕释放锁");
                lock.unlock(); //释放锁
            }
        }else{
            System.out.println("我是线程"+Thread.currentThread().getName()+"当前锁被别人占用，我无法获取");
        }
    }
}
