package com.zcw.queue;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 18:51 2020/6/24
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据队列");
            System.out.println("g(get):去除数据队列");
            System.out.println("h(head):查看头部数据队列");
            key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res= arrayQueue.getQueue();
                        System.out.println("取出的数据是:"+res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res= arrayQueue.headQueue();
                        System.out.println("队列头 的数据是:"+res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列-编写一个ArrayQueue的类
class ArrayQueue {
    private int maxSize;//表数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数组,模拟队列

    //创建构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部前一个位置
        rear = -1;//指向队列尾部数据(包含最后一个数据)
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据进队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满,不能加入");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }

    //数据处队列
    public int getQueue() {
        //判空
        if (isEmpty()) {
            //通过跑出异常处理
            throw new RuntimeException("队列空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空,没有数据");
            return;
        }
        for (int data : arr) {
            System.out.println(data);
        }
    }

    //显示队列投数据
    public int headQueue() {
        //判空
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        front++;
        return arr[front];
    }
}
