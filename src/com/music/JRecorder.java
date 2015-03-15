package com.music;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 23/08/2014
 * {@link http://www.solveitproblems.net/2010/04/java-sound-api-java.html}
 */
import javax.sound.sampled.*;
import javax.sound.sampled.AudioFileFormat.Type;
import java.io.File;
import java.io.IOException;

public class JRecorder extends Thread {
    private TargetDataLine       m_line;
    private AudioFileFormat.Type m_targetType;
    private AudioInputStream     m_audioInputStream;
    private File                 m_outputFile;

    public JRecorder(TargetDataLine m_line, Type m_targetType,  File m_outputFile) {
        this.m_line = m_line;
        this.m_targetType = m_targetType;
        this.m_audioInputStream = new AudioInputStream(m_line);
        this.m_outputFile = m_outputFile;
    }

    public void start(){
        m_line.start();
        super.start();
    }

    public void stopRecording(){
        m_line.stop();
        m_line.close();
    }

    public void run(){
        try{
            AudioSystem.write(m_audioInputStream, m_targetType, m_outputFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        File               outputFile = new File("data/wav/audiorec.wav");
        AudioFormat       audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100.0F, 16, 2, 4, 44100.0F, false);
        DataLine.Info            info = new DataLine.Info(TargetDataLine.class, audioFormat);
        TargetDataLine targetDataLine = null;

        try{
            targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);
        }catch (LineUnavailableException e){
            System.out.println("unable to get a recording line");
            e.printStackTrace();
            System.exit(1);
        }

        AudioFileFormat.Type targetType = AudioFileFormat.Type.WAVE;
        JRecorder                     j = new JRecorder(targetDataLine,targetType,outputFile);

        System.out.println("Press ENTER to start the recording.");
        try{
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }

        /* Here, the recording is actually started. */
        j.start();
        System.out.println("Recording...");
        System.out.println("Press ENTER to stop the recording.");
        try{
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }

        j.stopRecording();
        System.out.println("Recording stopped.");
    }
}