package com.zcw.queue;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 18:53 2020/6/24
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列");
        CircleArray circleArray = new CircleArray(4);//设为4,有效数据为3
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
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res= circleArray.getQueue();
                        System.out.println("取出的数据是:"+res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res= circleArray.headQueue();
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

class CircleArray {
    private int maxSize;//表数组最大容量

    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数组,模拟队列

    //创建构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部
        rear = 0;//指向队列尾部数据后一个位置
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear+1)%maxSize==front;
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
        //直接将数据加入
        arr[rear] = n;
        rear=(rear+1)%maxSize;//让rear后移,必须考虑取模

    }

    //数据处队列
    public int getQueue() {
        //判空
        if (isEmpty()) {
            //通过跑出异常处理
            throw new RuntimeException("队列空,不能取数据");
        }
        //将front保存进临时变量,front后移需考虑取模,再将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空,没有数据");
            return;
        }
        //思路从front开始遍历,多少个元素
        for (int i = front;i<getSize();i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //获得有效数据个数

    public int getSize() {
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列投数据
    public int headQueue() {
        //判空
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        return arr[front];
    }
}
