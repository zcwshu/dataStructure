package com.zcw;

import java.util.Random;

/**
 * @Author: AndrewBar
 * @Date: Created in 14:39 2020/8/12
 */
public class Hello {
    public static void main(String[] args) {
        String string = "andrewaixuexi";

        while(true){
            string += string + new Random().nextInt(888888888)+new Random().nextInt(999999999);
        }
       // Math.abs(-2) + Math.ceil(-5.3) + Math.round(-3.5)
          //String s1 = "123";
    }
}
