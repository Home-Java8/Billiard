package com.lessons.nasledovanie.lesson2;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2014
 */
public class B extends A {
    public B(){
        System.out.println("Constructor 'B'");
    }

    public String name = "B";

    public String getName(){
        return name;
    }
}
