package com.lessons.nasledovanie.lesson1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2014
 */
public class Main1 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println( "(A)Name: " + a.name );
        System.out.println( "(A)getName: " + a.getName() );
        a.getVirtual();

        System.out.println();

        B b = new B();
        System.out.println( "(B)Name: " + b.name );
        System.out.println( "(B)getName: " + b.getName() );
        b.getVirtual();

        System.out.println();

        C c = new C();
        System.out.println( "(C)Name: " + c.name );
        System.out.println( "(C)getName: " + c.getName() );
        c.getVirtual();
    }
}
