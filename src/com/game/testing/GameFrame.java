package com.game.testing;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 29/08/2014
 * {@link http://stackoverflow.com/questions/21459718/how-do-i-switch-jpanels-inside-a-jframe/21460065#21460065}
 * **********************************
 * How do I Switch JPanels inside a JFrame
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener{

    CardLayout   cardLayout;
    JPanel       mainPanel;
    LoadingPanel loading;
    GamePanel    game;
    JButton      toGame;

    public GameFrame() {
        cardLayout = new CardLayout();
        mainPanel  = new JPanel(cardLayout);

        loading    = new LoadingPanel();
        toGame     = new JButton("To Game");
        toGame.addActionListener(this);
        loading.add(toGame, BorderLayout.SOUTH);
        game       = new GamePanel();

        mainPanel.add(loading, "loading");
        mainPanel.add(game, "game");

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameOn();
    }

    public void gameOn() {
        cardLayout.show(mainPanel, "game");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                GameFrame gameFrame = new GameFrame();
            }
        });
    }
}


class LoadingPanel extends JPanel {

    public LoadingPanel() {
        setBackground(Color.GREEN);
        add(new JLabel("Loading..."));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}

class GamePanel extends JPanel {

    public GamePanel() {
        setBackground(Color.BLUE);
        add(new JLabel("To Game"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}