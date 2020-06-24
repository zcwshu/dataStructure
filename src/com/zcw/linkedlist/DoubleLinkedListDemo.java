package com.zcw.linkedlist;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:33 2020/6/24
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表测试");
        HeroNode2 hero1 = new HeroNode2(1,"松江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"无用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林聪","豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        HeroNode2 newHero = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.upDate(newHero);
        doubleLinkedList.list();

        System.out.println("删除操作演示");
        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}

//创建双向链表类
class DoubleLinkedList{
    //初始化一个头结点,头结点不要动,不存放具体数据
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    //显示链表[遍历]
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为head节点不能动,需要一个辅助遍历temp
        HeroNode2 temp = head.next;
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
    public void add(HeroNode2 heroNode){
        //因为head节点不能动,需要一个辅助遍历temp
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
    }
    //修改节点信息,根据no编号来修改,即no不能改
    public void upDate(HeroNode2 newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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
    //1.head不能动,需要辅助temp找到待删除节点
    //2.找到后自我删除
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;//直接从这开始
        boolean flag = false;     //标志是否找到待删除节点前一个节点
        while(true){
            if (temp == null)    {
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag){
            temp.pre.next = temp.next;//
            //如果是最后一个节点就不需要下面这句话
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }
        else{
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
    //第二种添加方式
    public void addByOrder(HeroNode2 heroNode){
        //因为head节点不能动,需要一个辅助遍历temp,找到添加的位置
        //因为是单链表,我们找的temp是添加位置的前一个节点,否则插入不了
        HeroNode2 temp = head;
        boolean flag =false;//表示添加的编号是否存在
        while (true){
            if (temp == null){
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
        temp.next.pre = heroNode;
        temp.pre = temp;
        temp.next = heroNode;
    }
}

//定义HeroNode2，每个HeroNode都是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点默认为null
    public HeroNode2 pre;//指向前一个节点默认为null

    public HeroNode2(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode [no="+ no +",name="+ name +",nickname="+ nickname +"]";
    }
}
