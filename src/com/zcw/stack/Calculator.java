package com.zcw.stack;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:28 2020/6/24
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "70+30*6-20";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描的得到的char保存到ch
        String keepNum = "";//用于拼接多位数
        //开始while循环扫描expression
        while (true){
            //依次得到expression的每个字符
            ch = expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    //处理
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    //为空直接入符号栈
                    operStack.push(ch);
                }
            }else{//如果是数不能直接入数栈，多位数会有问题，往index后再看一位
                //numStack.push(ch - 48);//根据ASCII码表转换的
                keepNum +=ch;
                //如果ch是最后一位
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }else{
                    //判断下一位是什么
                    //index不变
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //让index +1 ,并判断是否扫描到expression最后
            index++;
            if (index >=expression.length()){
                break;
            }
        }
        while (true){
            //如果符号栈为空,则计算到最后结果,数栈中只有一个数字结果
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d",expression,res2);
    }
}
class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //返回站定值得方法
    public int peek(){
        return stack[top];
    }
    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈,遍历需要从栈顶部开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
    //返回运算符优先级,优先级使用数字表示,数字越大优先级越高
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }
    public boolean isOper(char val){
        return val == '+' || val == '-' ||val == '*' ||val == '/';
    }
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch(oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
