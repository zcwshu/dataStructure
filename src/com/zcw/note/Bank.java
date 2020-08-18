package com.zcw.note;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: AndrewBar
 * @Date: Created in 10:03 2020/8/10
 */
public class Bank {
    private int count = 0;// 账户余额

    // 存钱
    public  void addMoney(int money) {
        synchronized(this){
            count += money;
        }

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + "存进：" + money);
    }

    // 取钱
    public void subMoney(int money) {
        synchronized(this){
            if (count - money < 0) {
                System.out.println("余额不足");
                return;
            }
            count -= money;
        }
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + "取出：" + money);
    }

    // 查询
    public void lookMoney() {

        System.out.println("账户余额：" + count);
    }

    @Test
    public void test(){
        lookMoney();
        addMoney(100);
        lookMoney();
        subMoney(50);
        lookMoney();
    }
}