package com.zcw.linkedlist;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:35 2020/6/24
 */
public class Josepffu {
    public static void main(String[] args) {
        //测试一把看看构建个遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList {
    //添加一个first节点,当前没有编号
    private Boy first = new Boy(-1);

    //添加小孩节点,构成环形链表
    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针帮助构建环形链表
        //用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);//创建节点
            //如果是第一个小行
            if (i == 1){
                first = boy;
                first.setNext(first);//构成环状
                curBoy = first;
            }else{
                curBoy.setNext(boy);//指向新的boy
                boy.setNext(first);//新的boy指向头
                curBoy = boy;//后移
            }
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        //判空
        if (first == null){
            System.out.println("链表为空,没有小孩");
            return;
        }
        //因为first不能动,需要辅助指针
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号是%d \n",curBoy.getNo());
            if (curBoy.getNext() == first){//遍历完了
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈
     */
    public void countBoy(int startNo,int countNum,int nums){
        //数据校验
        if (first == null|| startNo <1|| startNo>nums){
            System.out.println("参数输入有误,请重新输入");
        }
        Boy helper = first;
        //创建一个辅助指针helper,事先应该指向环形链表的最后一个节点
        while(true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前,,先让first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数时,,先让first和helper移动m-1次,然后出圈
        while(true){
            if (helper == first){
                break;
            }
            //让first和helper同时移动countNum-1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //first指向的节点,就是要出圈的小孩
            System.out.printf("出圈小孩的序号%d \n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",helper.getNo());
    }
}

//创建一个boy类表示节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
