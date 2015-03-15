package com.game;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 29/08/2014
 * {@link http://stackoverflow.com/questions/21459718/how-do-i-switch-jpanels-inside-a-jframe/21460065#21460065}
 * **********************************
 * How do I Switch JPanels inside a JFrame
 */
import com.game.music.LoadingProgress;
import com.game.music.PlayerAdapter;

import javax.swing.*;
import java.awt.*;

public class GameFrame{
    private static CardLayout cardLayout;
    private static JPanel     panel;
    private static GameStage  gameStage;

    public static JPanel init() {
        cardLayout   = new CardLayout();
        panel        = new JPanel(cardLayout);
        gameStage    = new GameStage(1330, 695);
        panel.add(LoadingProgress.loading(20), "loading");
        panel.add(gameStage, "game");
        return panel;
    }


    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Game - (onLine) Billiard");
        gameFrame.setLocation(0, 0);
        gameFrame.add(GameFrame.init());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);

//        System.out.println("> (1) Начало игры -> загружаю звуковые данные...");
        PlayerAdapter.load();

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                cardLayout.show(panel, "game");
                // Start the ball bouncing
                gameStage.gameStart();
            }
        });
    }

}
