package com.zcw.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:29 2020/6/24
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成中缀转后缀1+(2+3)*4-5=>1 2 3 + 4 * + 5 -
        //直接对字符串操作不方便,一次先将字符串转成中缀的listArrayList[1 + ( 2 + 3 ) * 4 - 5]
        //将得到的中缀表达式对应的list转为后缀表达式对应的list
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> parseSuffixExpression = parseSuffixExpression(infixExpressionList);
        System.out.println("后缀表达式="+parseSuffixExpression);

        //先定义一个逆波兰表达式 (3+4)*5-6=>3 4 + 5 * 6 -
        //说明方便,逆波兰表达式的数字符号使用空格隔开
        String suffixExpression = "100 1 + 5 * 6 -";
        //思路:1.现将3 4 + 5 * 6 -放到ArrayList
        // 2.将ArrayList传递给一个方法,遍历 配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);

        int res = calculate(parseSuffixExpression);
        System.out.println("计算结果是="+ res);
    }

    //将得到的中缀表达式对应的list转为后缀表达式对应的list
    public static List<String> parseSuffixExpression(List<String> ls){
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        //遍历ls
        for(String item:ls){
            //如果是一个数加入栈
            if(item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号,则一次弹出s1栈顶的运算符,并压入s2,直到遇到左括号为止,此时将一对括号丢弃
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//弹出s1栈,消除小括号
            }else{
                //当item的优先级小雨不等于栈顶的运算符优先级,将s1栈顶运算符弹出加入s2
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //将item压入栈
                s1.push(item);
            }
        }
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }
    //方法:将中缀表达式转成对应list
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;//这是一个指针,用于遍历
        String str;//多位数拼接
        char c;//每遍历到一个字符,就放到c
        do{
            //如果c是一个非数字,就需要加入到ls
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                ls.add("" +c);
                i++;
            }else{//如果是一个数考虑多位数
                str = "";//先将str置空
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }
    //将一个逆波兰表达式,一次将数据和运算符放入ArrayList
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成计算
    public static int calculate(List<String> ls) {
        //创建栈,只需要一个站即可
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : ls) {
            //使用正则表达式取出
            if (item.matches("\\d+")) {//匹配多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数并运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有问题");
                }
                stack.push(String.valueOf(res));
            }
        }
        //最后留在stack中的数据是
        return Integer.parseInt(stack.pop());
    }
}

//编写类返回运算符对应优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch(operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在改运算符");
                break;
        }
        return result;
    }
}
