package com.zcw.tree;

/**
 * @Author: AndrewBar
 * @Date: Created in 23:17 2020/7/14
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

    }
}

class BinaryTree{
    private BinaryTree root;

    public void setRoot(HeroNode heroNode){
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (root !=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空,不能查找");
        }
    }

    //中序
    public void infixOrder(){
        if (root !=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空,不能查找");
        }
    }

    //后序
    public void postorder(){
        if (root !=null){
            this.root.postorder();
        }else{
            System.out.println("二叉树为空,不能查找");
        }
    }
}

//创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //递归向左子树遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //中序遍历

    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        System.out.println(this);

        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}