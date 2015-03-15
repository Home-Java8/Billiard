package com.game.testing;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 28/08/2014
 */
public class MainMP3 {

    public static void main(String[] args) {
        System.out.println(">  [Load] 'rollong_ball.mp3'");
        MP3Player player = new MP3Player("data/mp3/rollong_ball.mp3");

        try{
            System.out.println(">  [Play]  10-sec.");
            player.play();
            Thread.sleep(10000);
            System.out.println("> [Pause]   5-sec.");
            player.pause();
            Thread.sleep(5000);
            System.out.println(">  [Play]   5-sec.");
            player.play();
            Thread.sleep(5000);
            player.pause();
            System.out.println("> [Pause]  10-sec.");
            Thread.sleep(10000);
            player.play();
            System.out.println(">  [Play]  10-sec.");
            Thread.sleep(10000);
            System.out.println(">  [Stop]");
            player.stop();
            System.out.println(">  [Play]");
            player.play();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
