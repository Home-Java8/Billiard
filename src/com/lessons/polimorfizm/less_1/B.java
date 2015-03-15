package com.polimorfizm.less_1;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 24/04/2014
 * {@link http://easylab.net.ua/java-ishodniki/nasledovanie-v-java}
 */

public class B extends A{
    private int sum;

    public B(){
        System.out.println("Вызов конструтора класса 'B'");
        sum = this.getValueA() + this.b + this.c;
    }

    @Override
    public String toString(){
        super.toString();
        return "Этот метод относится к классу 'B'";
    }

    public int getSum(){
        return sum;
    }
}
