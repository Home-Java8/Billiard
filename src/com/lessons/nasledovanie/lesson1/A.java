package com.lessons.nasledovanie.lesson1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2014
 */
public class A {
    public A(){
        System.out.println("Constructor 'A'");
    }

    public String name = "A";

    public String getName(){
        return name;
    }

    public void getVirtual(){
        fVirtual();
    }

    public void fVirtual(){
        System.out.println("Function 'A'");
    }

}
