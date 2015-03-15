package com.sorting;

/**
 * Created by Саша on 06.09.2014.
 */
public class SearchWorlds {

    public static void main(String[] args) {
        String[] worlds = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String myWorld = "aueysdT";

        System.out.println( "(" + myWorld + ") = '" + tmpWorld(worlds, myWorld) + "'" );
    }

    public static String tmpWorld(String[] worlds, String myWorld){
        String tmpWorld = new String();

        for(String world:worlds){
            char[] aLetter   = world.toCharArray();
            char[] aMyLetter = myWorld.toCharArray();
            int iLetter      = 0;

            for(char letter:aLetter){
                for(char myLetteer:aMyLetter){
                    if(letter == myLetteer){
                        iLetter++;
                    }
                }
            }
            if(world.length() == iLetter){
//                System.out.println("(" + myWorld + ") = '" + world + "'");
                tmpWorld = world;
            }
        }
        return tmpWorld;
    }

}
