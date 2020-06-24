package com.zcw.recursion;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:32 2020/6/24
 */
public class Queue8 {
    //定义一个max表示皇后数,定义一个数组表示皇后放的位置
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        //测试一把,8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有"+count+"种解法");
    }

    //编写一个方法放置第n个皇后
    //check是每次递归时,进入到check中都有for,以此会有回溯
    private void check(int n){
        if (n==max){//n=8,8个皇后已经放好
            print();
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后,放在该行第一列
            array[n] = i;
            //判断当放置第n个皇后到i列是是否冲突
            if (judge(n)){//不冲突
                //接着放n+1,即开始递归
                check(n+1);
            }
            //如果冲突,就继续执行array[n] = i;即将第n个皇后放置到本行后移的一个位置
        }
    }

    //查看当我们放置第n个皇后时,就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean  judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]判断第n个皇后和前面n-1个皇后在同一列
            //Math.abs(n -i) == Math.abs(array[n] - array[i]判断第n个皇后和第i个皇后在同一斜线
            //和数组有关
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    //写一个方法将皇后的位置打印
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
