package com.zcw.notecode;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:14 2020/8/13
 */
public class CacheLine1 {
    static long count = 1000000000L;
    private static class T{
        public long p1,p2,p3,p4,p5,p6,p7;
        public volatile long x = 0L;
        public long p9,p10,p12,p13,p14,p15,p16;
    }

    public static T[] arr = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(()->{
            for (long i = 0; i < count; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < count; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start) / 100_0000);
    }
}
