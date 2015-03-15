package com.game.testing;

import javax.swing.*;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 28/08/2014
 */
public class MainMidiLoading extends JFrame {
    private static short           playNum = 0;
    private static RePlayer[]     rePlayer = new RePlayer[20];

    public MainMidiLoading(String title){
        super(title);
        setLocation(3, 3);
        setSize(1350, 695);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(LoadingProgress.loading(rePlayer.length));
    }

    public static void main(String[] args) {
        try {
            MainMidiLoading midiLoading = new MainMidiLoading("Midi Loading");

            System.out.println("> (1) Начало игры -> загружаю звуковые данные...");
            load();
            // Жду 5-сек. когда загрузятся данные...
            Thread.sleep(5000);

            System.out.println("> (2) -> проигрываю звуковое сопровождение во время игры!");
            play(50);
            Thread.sleep(512);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(16);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(512);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(16);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(512);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(16);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(512);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(16);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(512);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(16);
            play(50);
            Thread.sleep(32);
            play(50);
            Thread.sleep(64);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(512);
            play(50);
            Thread.sleep(256);
            play(50);
            Thread.sleep(128);
            play(50);
            Thread.sleep(64);
            play(50);
            // (всего 54-ударов) Жду 5-сек. пока идет игра...
            Thread.sleep(5000);

            System.out.println("> (3) Игра окончена -> освобождаю рессурсы...");
            close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 3. Игра окончена (останавливаю все потоки) -> освобождаю рессурсы...
    public static void close(){
        for (int i = 0; i < rePlayer.length; i++)
            rePlayer[i].stop();
    }

    // 1. Начало игры (стартую потоки) -> загружаю звуковые данные...
    public static void load(){
        for (int i = 0; i < rePlayer.length; i++) {
            rePlayer[i] = new RePlayer();
            LoadingProgress.value = LoadingProgress.value + 1;
            LoadingProgress.progressBar.setValue(LoadingProgress.value);
        }
//        loadingProgress.labelText.setText("<html>" + "<font color=\"#FF0000\">" + "<b>" + "Completed." + "</b>" + "</font>" + "</html>");
    }

    // 2. -> проигрываю звуковое сопровождение во время игры!
//    public static void play(){
    public static void play(int sound){
        for (int i = (playNum%20); i < (rePlayer.length + (playNum%20)); i++){
////            if(soundThread[i].getThread().getState().toString().equals("WAITING")) { // RUNNABLE | WAITING
//            if(!rePlayer[i].getThread().getState().toString().equals("RUNNABLE")) { // RUNNABLE | WAITING
//                ////
//                System.out.println(" [" + (playNum%20) + "] = " + playNum + "");
//                if((playNum%20) == 19) System.out.println();
//                ////
            rePlayer[i].play(sound);
            playNum++;
            return;
//            } else {
//                ////
//                System.out.print("  " + i);
//                ////
//            }
        }
    }

    private static class RePlayer implements Runnable {
        private Thread     thread;
        private boolean    isPlay;
        private boolean    isSuspend;
        private MidiPlayer midi;
        private int        sound;

        public RePlayer() {
            isSuspend = true;
            isPlay    = true;
            midi      = new MidiPlayer();
            thread    = new Thread(this, "Player");
            thread.start();
        }

        public void run() {
            try {
                while( isPlay ){
                    synchronized(this) {
                        if(isSuspend) {
                            wait();
                        } else {
                            midi.play(9, 1000, 100, sound);
                            // Приостановить поток
                            isSuspend = true;
                        }
                    }
                }
            } catch(InterruptedException e) {e.printStackTrace();}
        }

//        public Thread getThread(){
//            return thread;
//        }

        // Возобновить поток
        public synchronized void play(int sound) {
            this.sound = sound;
            isSuspend  = false;
            notify();
        }

        // Остановить поток
        public void stop() {
            midi.close();
//        thread.stop();
            isPlay = false;
            play(sound);
//        if( thread.isInterrupted() )
//            thread.interrupt();
        }
    }
}
