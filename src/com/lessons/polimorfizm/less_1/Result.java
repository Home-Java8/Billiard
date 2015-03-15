package com.polimorfizm.less_1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 24/04/2014
 * {@link http://ecomputernotes.com/java/inheritance/inheritance-protected-members}
 */

public class Result extends Num{

    Result(int a,int b){
        super(a, b);
    }

    private int z;

    public void add(){
        z = x + y;
    }

    public void showZ(){
        System.out.println("z = " + z);
    }
}