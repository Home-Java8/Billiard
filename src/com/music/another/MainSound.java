package com.music.another;

/**
 * Created by Саша on 20.08.2014.
 */
public class MainSound {

    public static void main(String[] args){
//        try {
////            File soundFile = new File("snd.wav"); //Звуковой файл
//            File soundFile = new File("data/audioFiles/vitas-zvezda.mp3"); //Звуковой файл
//
//            //Получаем AudioInputStream
//            //Вот тут могут полететь IOException и UnsupportedAudioFileException
//            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
//
//            //Получаем реализацию интерфейса Clip
//            //Может выкинуть LineUnavailableException
//            Clip clip = AudioSystem.getClip();
//
//            //Загружаем наш звуковой поток в Clip
//            //Может выкинуть IOException и LineUnavailableException
//            clip.open(ais);
//
//            clip.setFramePosition(0); //устанавливаем указатель на старт
//            clip.start(); //Поехали!!!
//
//            //Если не запущено других потоков, то стоит подождать, пока клип не закончится
//            //В GUI-приложениях следующие 3 строчки не понадобятся
//            Thread.sleep(clip.getMicrosecondLength()/1000);
//            clip.stop(); //Останавливаем
//            clip.close(); //Закрываем
////        } catch(IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
//        } catch(IOException  exc) {
//            exc.printStackTrace();
//        }catch(UnsupportedAudioFileException exc) {
//            exc.printStackTrace();
//        }
//        catch(LineUnavailableException exc) {
//            exc.printStackTrace();
//        } catch (InterruptedException exc) {}

        Sound.playSound("data/audioFiles/vitas-zvezda.mp3").join();

    }

}
