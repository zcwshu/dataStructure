package com.zcw.tree;

/**
 * @Author: AndrewBar
 * @Date: Created in 13:17 2020/7/25
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

//编写一个ArrBinaryTree,实现顺序存储二叉树
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    //编写一个方法完成顺序存储二叉树的前序遍历

    /**
     *
     * @param index Index为数组下标
     */
    public void preOrder(int index){
        //如果数组为空,或者arr.length = 0
        if (arr == null || arr.length == 0){
            System.out.println("数组为空,不能按照二叉树的前序遍历");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 +1)<arr.length){
            preOrder(2 * index +1);
        }
        //向右递归
        if ((index * 2 + 2)<arr.length){
            preOrder(index * 2 + 2);
        }
    }
}
