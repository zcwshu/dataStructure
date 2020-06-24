package com.zcw.linkedlist;

import java.util.Stack;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:34 2020/6/24
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1,"松江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"无用","智多星");
        HeroNode hero4 = new HeroNode(4,"林聪","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //测试一个单链表反转
        System.out.println("原来链表的情况");
        singleLinkedList.list();
//        System.out.println("反转链表的情况");
////        reverseList(singleLinkedList.getHead());
        System.out.println("逆序打印单链表");
        reversePrint(singleLinkedList.getHead());
        singleLinkedList.list();
        /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.list();
        //按照编号加入
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);
        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2,"小卢","石麒麟");
        singleLinkedList.upDate(newHeroNode);
        singleLinkedList.del(1);

        //显示
        singleLinkedList.list();
        System.out.println(getLength(singleLinkedList.getHead()));
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.println(res);*/
    }

    //方法获取单链表的有效节点个数(如果是带头结点的链表,需要不统计头结点)
    /**
     *
     * @param head 头结点
     * @return 有效节点个数
     */
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    //查找链表中倒数第k个节点
    //编写一个方法接收head节点,同时接收一个index
    //index表示倒数第index个节点
    //先遍历链表得到总长度(getLength)
    //得到size后,从第一个遍历到size-index个,就可以得到
    //找到返回该节点,没找到返回空
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        //第一个遍历得到链表长度
        int size = getLength(head);
        //第二次遍历size-index
        if (index <= 0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //单链表反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空或只有一个节点，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助变量遍历链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点（cur）下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点将其取出，放在reverseHead的前端
        while (cur != null){
            next = cur.next;//先保存当前节点的下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新链表头部
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移指向下一个节点
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }
    //使用栈逆序打印
    public static void reversePrint(HeroNode head){
        if (head.next ==null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;//cur后移
        }
        //打印
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
//定义一个SingleLinkedList,管理我们的英雄
class SingleLinkedList{
    //初始化一个头结点,头结点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }
    //添加节点到单向链表
    //思路:当不考虑编号顺序时
    //1.找到当前链表的最后一个节点
    //2.将最后一个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动,需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后,temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //第二种添加方式
    public void addByOrder(HeroNode heroNode){
        //因为head节点不能动,需要一个辅助遍历temp,找到添加的位置
        //因为是单链表,我们找的temp是添加位置的前一个节点,否则插入不了
        HeroNode temp = head;
        boolean flag =false;//表示添加的编号是否存在
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){//位置找到,就在temp后面插入
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;//编号存在
                break;
            }
            temp = temp.next;//后移遍历
        }
        if (flag){
            System.out.printf("准备插入的英雄编号%d已经存在,不能加入\n",heroNode.no);
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }
    //修改节点信息,根据no编号来修改,即no不能改
    public void upDate(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if (temp == null){//链表遍历结束
                break;
            }
            if (temp.no == newHeroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{//没有找到
            System.out.printf("没有找到编号%d的节点,不能修改\n",newHeroNode.no);
        }
    }

    //删除节点
    //1.head不能动,需要辅助temp找到待删除节点的前一个节点
    //2.比较时用temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;     //标志是否找到待删除节点前一个节点
        while(true){
            if (temp.next == null)    {
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag){
            temp.next = temp.next.next;
        }
        else{
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
    //显示链表[遍历]
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为head节点不能动,需要一个辅助遍历temp
        HeroNode temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode [no="+ no +",name="+ name +",nickname="+ nickname +"]";
    }
}
