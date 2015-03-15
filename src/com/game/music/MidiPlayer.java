package com.game.music;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 20/08/2014
 * {@link http://habrahabr.ru/post/211480/}
 * ****************************************
 * Таблица номеров программ и звуков стандарта General MIDI
 * {@link http://pisali.ru/muzmart/36074/}
 */
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MidiPlayer {
    private MidiChannel[]     midi = null;
    private Synthesizer syntezator = null;

      public MidiPlayer() {
        // Создаем тип звукового-объекта "MidiSystem" - это ранее запрограммированные данные, архив музыкальных эффектов
        // и иннициализируем воспроизводящее устройство - синтезатор "Synthesizer"
        try {
            syntezator    = MidiSystem.getSynthesizer();
            syntezator.open(); // запрашиваем-берем у системы выделения аудио-рессурса...
            midi          = syntezator.getChannels();
            midi[9].programChange(9);
        } catch(MidiUnavailableException ex){Logger.getLogger(MidiPlayer.class.getName()).log(Level.SEVERE, null, ex);}
    }

    public void close() {
        syntezator.close(); // возвращаем-закрываем используемые аудио-рессурсы...
    }

    public void play(int channel, int duration, int volume, int... notes) {
        for( int note : notes )
            midi[channel].noteOn(note, volume); // ("noteOn") играть установленую ноту (или ноты, если указано несколько) с указаной громкостью и выбранным звуковым эффектом

        try {
            Thread.sleep(duration); // приостанавливаем процесс на время воспроисведения музыкальных нот
        } catch(InterruptedException ex){Logger.getLogger(MidiPlayer.class.getName()).log(Level.SEVERE, null, ex);}

        for( int note : notes )
            midi[channel].noteOff(note); // ("noteOff") прервать игру нот...
    }
}
