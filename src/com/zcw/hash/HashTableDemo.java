package com.zcw.hash;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 9:34 2020/6/27
 */
public class HashTableDemo {
    public static void main(String[] args) {
        //创建hash表
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add:添加员工");
            System.out.println("list:显示员工");
            System.out.println("find:查找员工");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch(key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建员工
                    Emp emp = new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建hashtable,管理多条链表
class HashTable{
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        //初始化
        empLinkedLists = new EmpLinkedList[size];
        //留个坑,这时不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加员工
    public void add(Emp emp){
        //根据员工id,得到该员工应该添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp加入到对应链表
        empLinkedLists[empLinkedListNO].add(emp);
    }
    //遍历链表
    public void list(){
        for(int i = 0;i < size;i++){
            empLinkedLists[i].list(i);
        }
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        //使用散列函数确定那个链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNO].findEmpByID(id);
        if (emp != null){
            System.out.printf("在%d条链表中找到雇员 id=%d\n",(empLinkedListNO+1),id);
        }else{
            System.out.println("在哈希表中没有找到该雇员");
        }
    }

    //编写一个散列函数,使用取模法
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个员工
class Emp{
    public int id;
    public String name;
    public Emp next;//默认为空

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
//表示链表
class EmpLinkedList{
    //头指针,执行第一个Emp,一次我们链表的head 直接指向第一个Emp
    private Emp head;//默认为空

    //添加
    //1.当添加员工时,id是自增的,即id的分配总是从小到大
    //因此直接将员工加入到链表最后
    public void add(Emp emp){
        //如果是添加第一个员工
        if(head == null){
            head = emp;
            return;
        }
        Emp curEmp = this.head;
        while(true){
            if (curEmp.next == null){//说明到链表最后
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp,加入链表
        curEmp.next = emp;
    }

    //遍历
    public void list(int no){
        if (head == null){
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.println("第" + no + "链表信息为");
        Emp curEmp = this.head;//辅助指针
        while(true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //查找员工
    //找到返回Emp,没有返回空
    public Emp findEmpByID(int id){
        if (head == null){
            System.out.println("链表为空");
        }
        Emp curEmp = this.head;
        while(true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return  curEmp;
    }
}
