package com.polimorfizm.less_1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 24/04/2014
 * {@link http://ecomputernotes.com/java/inheritance/inheritance-protected-members}
 */

public class Num {
    // Protected Members:
    protected int x, y;

    Num(int a, int b){
        x = a;
        y = b;
    }

    public void showXY() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}