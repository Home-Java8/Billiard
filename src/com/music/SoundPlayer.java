package com.music;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 24/08/2014
 * {@link http://hashcode.ru/questions/18294/sound-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81%D0%BE-%D0%B7%D0%B2%D1%83%D0%BA%D0%BE%D0%BC-%D0%B2-java}
 * **********************************
 * Реализуем новый проигрыватель файлов. Воспроизведение с помощью SourceDataLine канала данных
 */
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class SoundPlayer extends JFrame implements Runnable {
    private File             currentDir;
    private JComboBox        soundChoice;
    private String           oldFilename;     // Предыдущее имя файла
    private JButton          play;            // Кнопка PLAY
    private boolean          playing = false; // Управление потоком
    private SourceDataLine   sourceLine;      // Поток для звукового файла
    private int              bufferSize;      // Размер буфера в байтах
    private AudioInputStream source;          // Канал для вывода звука
    private byte[]           soundData;       // Буфер для хранения значений звука
    private Thread           thread;          // Программный поток воспроизведения

    public SoundPlayer(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SoundFile Player");
        setSize(300, 90);
        setLocation(500, 100);

        // Получить имена звуковых файлов
        currentDir = new File (System.getProperty("user.dir"));
        FilenameFilter filter = new FilenameFilter(){
            public boolean accept (File directory, String filename){
                String name = filename.toLowerCase();
                return name.endsWith(".wav")||name.endsWith(".au")||name.endsWith(".aif");

            }
        };
        String soundFiles[] = currentDir.list(filter);
        if (soundFiles == null|| soundFiles.length == 0 ){
            JOptionPane.showMessageDialog(this, "No Sound Files  - terminating","Sound Files Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        soundChoice = new JComboBox(soundFiles);
        soundChoice.setSelectedIndex(0);
        newSound(soundFiles[0]);       // Это типа метод
        oldFilename = (soundFiles[0]); // Это тоже
        soundChoice.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  newSound((String)soundChoice.getSelectedItem());
              }
          }
        );
        // Настройка кнопки PLAY для воспроизведения текущего звукового файла
        play = new JButton("PLAY");
        play.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   if(e.getActionCommand().equals("PLAY")){
                       startPlay();          //Начинаем воспроизведение
                       play.setText("STOP"); // Меняем надпись на кнопке
                   }else{
                       stopPlay();
                       play.setText("Text");
                   }
               }
           }
        );
        Container content = getContentPane();
        content.add(soundChoice);
        content.add(play, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args){
        SoundPlayer soundPlayer = new SoundPlayer();
    }

    public void newSound(String filename){
        // Задать текущий файл для воспроизведения

        File soundFile = new File(currentDir, filename);
        // Мы можем иметь уже воспроизводившийся файл
        if(sourceLine != null){
            // Если имеется линия соединения
            if(sourceLine.isActive()) // и если она ещё и активна,
                sourceLine.stop();    // то остановим её
            play.setText("TEXT");
        }

        // Теперь проверить для потока и линии соединения
        try{
            AudioInputStream newSource = AudioSystem.getAudioInputStream(soundFile);
            if(newSource.markSupported())          // Если можно маркировать поток?!
                newSource.mark(Integer.MAX_VALUE); // то маркируем для будущего использования

            // Получить аудиоформат
            AudioFormat       format = newSource.getFormat();
            DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, format);
            if(AudioSystem.isLineSupported(sourceInfo)){
                // если тип соединения поддерживается, то получить новый канал
                sourceLine  = (SourceDataLine)AudioSystem.getLine(sourceInfo);
                bufferSize  = (int)(format.getFrameSize()*format.getFrameSize()/2.0f);
                // открыть линию соединения
                sourceLine.open(format, bufferSize);
                // Новая линия в порядке - поэтому сохранить её
                source      = newSource;
                // создать буфер для чтения
                soundData   = new byte[bufferSize];
                // сохранить имя текущего файла
                oldFilename = filename;

            }else{
                JOptionPane.showMessageDialog(null, "Lise not supported", "Line NOTSUPPORTED", JOptionPane.WARNING_MESSAGE);
                // Востановить старый выбор
                soundChoice.setSelectedItem(oldFilename);
            }
        }catch (UnsupportedAudioFileException e){
            JOptionPane.showMessageDialog(null, "File is not supported", "Unsupported File Type", JOptionPane.WARNING_MESSAGE);
            soundChoice.setSelectedItem(oldFilename);

        }catch(LineUnavailableException e){
            JOptionPane.showMessageDialog(null, "Line is not aviable","Line Error", JOptionPane.WARNING_MESSAGE);
            soundChoice.setSelectedItem(oldFilename);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "I/O Erroe", "I/O Error", JOptionPane.WARNING_MESSAGE);
            soundChoice.setSelectedItem(oldFilename);

        }
    }

    // начать воспроизведение текущего файла
    public void startPlay(){
        if(sourceLine == null){
            // Убедимя, что у нас есть канал
            JOptionPane.showMessageDialog(null, "No line available", "Play Problem", JOptionPane.WARNING_MESSAGE);
            return;
        }
        thread  = new Thread(this); // создать поток воспроизведения
        playing = true;             // флаг
        thread.start();             // запустить поток
    }

    // Остановить
    public void stopPlay(){
        playing = false;
    }

    public void run(){
        sourceLine.start(); // Запустить линию
        int byteCount = 0;  // прочитано байтов
        try{
            while(playing){
                // читать поток
                byteCount = source.read(soundData, 0, soundData.length);
                if(byteCount == -1){
                    // Если конец ввода
                    if(source.markSupported())  // и мы можем восстановить поток
                        source.reset(); // вернуть его к началу
                    sourceLine.drain(); // Воспроизвести то, что осталось в буфере
                    playing = false;
                    break;
                }
                // Записать массив в канал
                sourceLine.write(soundData, 0, byteCount);
            }
        }catch (IOException e){
            System.err.println(e);
        }
        sourceLine.stop(); // Остановим канал
        play.setText("PLAY");
    }
}