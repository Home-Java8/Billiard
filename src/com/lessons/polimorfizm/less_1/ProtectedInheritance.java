package com.polimorfizm.less_1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 24/04/2014
 * {@link http://ecomputernotes.com/java/inheritance/inheritance-protected-members}
 */

public class ProtectedInheritance {

    public static void main(String[] args){
        Result result = new Result(5, 6);

        result.showXY();
        result.add();
        result.showZ();
    }
}