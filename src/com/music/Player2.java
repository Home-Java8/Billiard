package com.music;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 23/08/2014
 * {@link http://programmingmaster.ru/1197-vosproizvedenie-midi-zvykov-na-jazyke-java}
 * **********************************
 * http://habrahabr.ru/post/211480/
 */
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player2 {
    private MidiChannel[] channels = null;
    private Synthesizer      synth = null;

    public Player2() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
            channels[0].programChange(41);
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args){
        Player2 player2 = new Player2();
        player2.playSound(0, 1000, 100, 42);
        player2.close();
    }

    public void close() {
        synth.close();
    }

    public void playSound(int channel, int duration, int volume, int... notes) {
        for (int note : notes) {
            channels[channel].noteOn(note, volume);
        }
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int note : notes) {
            channels[channel].noteOff(note);
        }
    }
}

