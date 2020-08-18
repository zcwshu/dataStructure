package com.zcw.tree.thread;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:58 2020/7/27
 */
public class ThreadeBinaryTreeDemo {
    public static void main(String[] args) {

    }
}

//定义二叉树 实现线索化功能的二叉树
class BinaryTree{
    private HeroNode root;

    //为了实现线索化,需要创建要给指向当前节点的前驱节点的指针
    //在递归线索化时,pre 总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root){
        this.root = root;
    }
    /**
     *编写对二叉树进行中序线索化的方法
     * @param node 就是当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node){
        //如果node==null,不能线索化
        if (node == null){
            return;
        }
        //先线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null){
            //当前节点的左指针
        }
        //再线索化右子树
        threadedNodes(node.getRight());

    }

    //删除节点
    public void delNode(int no){
        if (root != null){
            //如果只有一个root节点,这里需要立即判断
            if (root.getNo() == no){
                root = null;
            }else{
                //递归删除
                root.deleteNode(no);
            }
        }else{
            System.out.println("空树,不能删除");
        }
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
    public com.zcw.tree.thread.HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    public com.zcw.tree.thread.HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    public com.zcw.tree.thread.HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }
}

//创建HeroNode
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //如果leftType == 0 表示指向左子树,如果1 则表示指向前驱节点
    //如果rightType == 0 表示指向右子树,如果1 则表示指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    //递归删除节点
    public void deleteNode(int no) {
        //判断左子节点是否为要删除的节点
        if (this.left != null && this.left.no == no) {
            //if (this.left.left != null)
            this.left = null;
            return;
        }
        //判断右子节点是否为要删除的节点
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //递归判断左子树
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        //递归判断右子树
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("1次");
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        HeroNode resnode = null;
        if (this.left != null) {
            resnode = this.left.preOrderSearch(no);
        }
        if (resnode != null) {//说明左子树上找到
            return resnode;
        }
        if (this.right != null) {
            resnode = this.right.preOrderSearch(no);
        }
        return resnode;
    }

    //中序遍历查找

    public HeroNode infixOrderSearch(int no) {
        HeroNode resnode = null;
        if (this.left != null) {
            resnode = this.left.infixOrderSearch(no);
        }
        if (resnode != null) {//说明左子树上找到
            return resnode;
        }
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resnode = this.right.infixOrderSearch(no);
        }
        return resnode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resnode = null;
        if (this.left != null) {
            resnode = this.left.postOrderSearch(no);
        }
        if (resnode != null) {//说明左子树上找到
            return resnode;
        }
        if (this.right != null) {
            resnode = this.right.postOrderSearch(no);
        }
        if (resnode != null) {//说明左子树上找到
            return resnode;
        }
        if (this.no == no) {
            return this;
        }
        return resnode;
    }
}
