package com.sorting;

/**
 * Created by Саша on 06.09.2014.
 */
public class Search2Worlds {

    public static void main(String[] args) {
        String[] worlds = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String  myWorld = "TuesydneWeTFrisdaydayrsdadayhu";

        System.out.println( "'" + myWorld + "' > (" + myFilter(myWorld) + ") = " + mySorted(worlds, myFilter(myWorld)) );
    }


    public static String myFilter(String myWorld){
        char[]  aMyWorld = myWorld.toCharArray();
        char[] aTmpWorld = new char[myWorld.length()];
        int         iTmp = 0;
        boolean    found;

        for(char letter:aMyWorld){
            found = false;
            for (int i = 0; i < iTmp; i++){
                if(aTmpWorld[i] == letter){
                    found = true;
                    i = iTmp;
                }
            }
            if(!found){
                aTmpWorld[iTmp] = letter;
                iTmp++;
            }
        }

        char[] aMy2World = new char[iTmp];
        int iMy2World    = 0;
        for(int a = 0; a < aTmpWorld.length; a++){
            if(Character.isLetter(aTmpWorld[a])) {
                aMy2World[iMy2World] = aTmpWorld[a];
                iMy2World++;
            }
        }

        return String.valueOf(aMy2World);
    }

    public static String mySorted(String[] worlds, String myWorld){
        String tmp2World = new String();

        for(String world:worlds){
            char[] aLetter   = world.toCharArray();
            char[] aMyLetter = myWorld.toCharArray();
            int iLetter      = 0;

            for(char letter:aLetter)
                for(char myLetteer:aMyLetter){
                    if(letter == myLetteer){
                        iLetter++;
                    }
                }

            if(world.length() == iLetter)
                tmp2World += "'" + world + "' ";
        }

        return tmp2World;
    }

}
