package com.game.testing2;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 25/08/2014
 * {@link http://ru.wikibooks.org/wiki/Java/%D0%A2%D0%B8%D0%BF%D1%8B_%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85}
 * {@link http://sernam.ru/book_java.php?id=4}
 * {@link http://habrahabr.ru/post/104231/}
 * ****************************************
 * Целочисленные типы данных
 */
public class Type {
    public static void main (String [] arg){
        byte   typeByte = 127;
        short typeShort = 32767;
        int     typeInt = 2147483647;
        long   typrLong = 9223372036854775807L;
        float floatType = 932337.2F;
        double doubleType = 922337.12D;

        System.out.println( "  (byte) = " + typeByte );
        System.out.println( " (short) = " + typeShort );
        System.out.println( "   (int) = " + typeInt );
        System.out.println( "  (long) = " + typrLong );
        System.out.println( " (float) = " + floatType );
        System.out.println( "(double) = " + doubleType );
    }
}
