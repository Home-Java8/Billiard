package com.music;


/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 20/08/2014
 * {@link http://www.morgenstille.at/blog/how-to-play-a-mp3-file-in-java-simple-and-beautiful/}
 * {@link http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-client-419417.html#7372-jmf-2.1.1e-oth-JPR}
 * {@link https://javaextreme.wordpress.com/tag/mp3plugin-jar/}
 * {@link http://www.cs.uccs.edu/~cs525/jmf/jmf.html}
 */
import javax.media.*;
import javax.media.Player;
import javax.media.format.AudioFormat;
import java.io.File;


public class AudioTest {
    public static void main(String[] args) {
        Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
        Format input2 = new AudioFormat(AudioFormat.MPEG);
        Format output = new AudioFormat(AudioFormat.LINEAR);
        PlugInManager.addPlugIn(
                "com.sun.media.codec.audio.mp3.JavaDecoder",
                new Format[]{input1, input2},
                new Format[]{output},
                PlugInManager.CODEC
        );

        try{
//            Player player = Manager.createPlayer(new MediaLocator(new File("data/mp3/dusche.mp3").toURI().toURL()));
            Player player = Manager.createPlayer(new MediaLocator(new File("data/mp3/vitas-zvezda.mp3").toURI().toURL()));
            player.start();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}