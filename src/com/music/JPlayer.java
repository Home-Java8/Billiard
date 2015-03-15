package com.music;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 23/08/2014
 * {@link http://www.solveitproblems.net/2010/04/java-sound-api-java.html}
 * **********************************
 * Написать Аудио плеер еще легче, привожу семпл код
 */
import javax.sound.sampled.*;
import java.io.*;

public class JPlayer {

    String           filename;
    AudioInputStream ais;

    public JPlayer(String filename) {
        this.filename = filename;
        this.initialize();
    }

    public void initialize(){
        try {
            ais = AudioSystem.getAudioInputStream( new File(filename) );
        } catch (Exception e) {
            System.out.println("Exception in initializing. "+e);
        }

        AudioFormat    format = ais.getFormat();
        SourceDataLine   line = null;
        DataLine.Info    info = new DataLine.Info(SourceDataLine.class,format);

        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            int    nBytesRead = 0;
            byte[]     abData = new byte[128000];
            while( nBytesRead != -1 ){
                try{
                    nBytesRead = ais.read( abData, 0, abData.length );
                }catch (IOException e){
                    e.printStackTrace();
                }
                if (nBytesRead >= 0){
                    int nBytesWritten = line.write(abData, 0, nBytesRead);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in inintializing. getting line. " + e);
        }

        line.drain();
        line.close();
    }

    public static void main(String args[]){
        JPlayer jp = new JPlayer("data/wav/audiorec.wav"); // data/wav/Звуки-Песенка_кота_Матроскина.wav
    }
}

