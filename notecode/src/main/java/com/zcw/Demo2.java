package com.zcw;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:18 2020/8/12
 */
public class Demo2 {
    public static void main(String[] args) {
        //返回虚拟机视图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();  //字节 1024 * 1024
        //返回JVM总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+ max+"字节\t"+(max/(double)1024/1024)+"MB");        //四分之一
        System.out.println("total="+ total+"字节\t"+(total/(double)1024/1024)+"MB");  //1/64

        //默认情况下 : 分配的总内存 是电脑内存的1/4 , 而初始化的内存 : 1/64
        //OOM
        //1. 尝试扩大堆内存看结果
        //2. 分析内存,看一下哪个地方出现了问题(专业工具)
        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails
        //-Xms 设置初始化内存分配大小,默认1/64
        //-Xmx 设置最大分配内存,默认1/4
        //-XX:+PrintGCDetails  打印GC辣鸡回收信息
        //-XX:+HeapDumpOnOutOfMemoryError   OOM Dump
    }
}
