package com.polimorfizm.less_1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 24/04/2014
 * {@link http://easylab.net.ua/java-ishodniki/nasledovanie-v-java}
 */

import java.util.Random;

public class A {

//    private   Random rand;
    private      int a = 0;
    protected    int b = 0;
    public       int c = 0;

    public A(){
        System.out.println("Вызов конструктора #1 класса 'A'");
//        rand = new Random();
//        a    = rand.nextInt(10);
//        b    = rand.nextInt(10);
//        c    = rand.nextInt(10);
        a = 2;
        b = 4;
        c = 6;
    }

    @Override
    public String toString(){
        return "(a)" + a + " (b)" + b + " (c)" + c;
    }

    protected int getValueA(){
        return a;
    }
}

