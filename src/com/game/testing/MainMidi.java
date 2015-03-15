package com.game.testing;

/**
 * Created by Саша on 27.08.2014.
 */
public class MainMidi {

    public static void main(String[] args){
        try {
            System.out.println("> (1) Начало игры -> загружаю звуковые данные...");
            PlayerAdapter.load();
            // Жду 5-сек. когда загрузятся данные...
            Thread.sleep(5000);

            System.out.println("> (2) -> проигрываю звуковое сопровождение во время игры!");
            PlayerAdapter.play(50);
            Thread.sleep(512);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(16);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(512);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(16);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(512);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(16);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(512);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(16);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(512);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(16);
            PlayerAdapter.play(50);
            Thread.sleep(32);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(512);
            PlayerAdapter.play(50);
            Thread.sleep(256);
            PlayerAdapter.play(50);
            Thread.sleep(128);
            PlayerAdapter.play(50);
            Thread.sleep(64);
            PlayerAdapter.play(50);
            // (всего 54-ударов) Жду 5-сек. пока идет игра...
            Thread.sleep(5000);

            System.out.println("> (3) Игра окончена -> освобождаю рессурсы...");
            PlayerAdapter.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
