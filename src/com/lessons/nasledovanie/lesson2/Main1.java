package com.lessons.nasledovanie.lesson2;

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

        System.out.println();

        A ab = new B();
        System.out.println( "(AB)Name: " + ab.name );
        System.out.println( "(AB)getName: " + ab.getName());

        System.out.println();

        A ac = new C();
        System.out.println( "(AC)Name: " + ac.name );
        System.out.println( "(AC)getName: " + ac.getName());

        System.out.println();

        B bc = new C();
        System.out.println( "(BC)Name: " + bc.name );
        System.out.println( "(BC)getName: " + bc.getName());
    }
}
