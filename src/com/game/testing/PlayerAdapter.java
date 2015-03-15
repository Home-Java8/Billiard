package com.game.testing;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 25/08/2014
 * {@link http://www.sql.ru/forum/537603/priostanovka-i-vozobnovlenie-potoka}
 * **********************************
 * приостановка и возобновление потока
 */
public class PlayerAdapter {

    private static short       playNum = 0;
    private static RePlayer[] rePlayer = new RePlayer[20];

    // 3. Игра окончена (останавливаю все потоки) -> освобождаю рессурсы...
    public static void close(){
        for (int i = 0; i < rePlayer.length; i++)
            rePlayer[i].stop();
    }

    // 1. Начало игры (стартую потоки) -> загружаю звуковые данные...
    public static void load(){
        for (int i = 0; i < rePlayer.length; i++)
            rePlayer[i] = new RePlayer();
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
