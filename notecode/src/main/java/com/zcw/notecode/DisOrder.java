package com.zcw.notecode;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:22 2020/8/13
 */
public class DisOrder {
    private static int x = 0,y = 0;
    private static int a = 0,b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;){
            i++;
            x = 0;y = 0;
            a = 0;b = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    //由于线程one先启动,下面这句话让他等一等线程two
                    //shortWait(10000);
                    a = 1;
                    x = b;
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    x = b;
                }
            });
            one.start();other.start();
            one.join();other.join();
            String res = "第" + i + "次("+ x + ","+ y + ")";
            if (x == 0 && y == 0){
                System.out.println(res);
                break;
            }else{
                //System.out.println(res);
            }
        }
    }

}
