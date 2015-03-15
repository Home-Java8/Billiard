package com.lessons.nasledovanie.lesson2;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2014
 */
public class C extends B {
    public C(){
        System.out.println("Constructor 'C'");
    }

    public String name = "C";

    public String getName(){
        return name;
    }
}