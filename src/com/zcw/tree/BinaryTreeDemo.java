package com.zcw.tree;

/**
 * @Author: AndrewBar
 * @Date: Created in 23:17 2020/7/14
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明,我们先手动创建二叉树,后面学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();

        //前序遍历
        System.out.println("前序遍历的方式");
        HeroNode heroNode = binaryTree.preOrderSearch(5);
        if (heroNode != null){
            System.out.printf("找到了信息为no=%d name=%s",heroNode.getNo(),heroNode.getName());
        }else{
            System.out.printf("没有找到no=%d的英雄",5);
        }
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
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
    public void postOrder(){
        if (root !=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空,不能查找");
        }
    }

    //前序
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
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

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }
    }

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

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("1次");
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        HeroNode resnode = null;
        if (this.left != null){
            resnode = this .left.preOrderSearch(no);
        }
        if (resnode != null){//说明左子树上找到
            return resnode;
        }
        if (this.right != null){
            resnode = this.right.preOrderSearch(no);
        }
        return resnode;
    }

    //中序遍历查找

    public HeroNode infixOrderSearch(int no){
        HeroNode resnode = null;
        if (this.left != null){
            resnode = this .left.infixOrderSearch(no);
        }
        if (resnode != null){//说明左子树上找到
            return resnode;
        }
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resnode = this.right.infixOrderSearch(no);
        }
        return resnode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resnode = null;
        if (this.left != null){
            resnode = this .left.postOrderSearch(no);
        }
        if (resnode != null){//说明左子树上找到
            return resnode;
        }
        if (this.right != null){
            resnode = this.right.postOrderSearch(no);
        }
        if (resnode != null){//说明左子树上找到
            return resnode;
        }
        if (this.no == no){
            return this;
        }
        return resnode;
    }

}