package com.game.testing.d2;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: artur
 * Date: 01.09.14
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */

public class DisplayImage extends JFrame {

    public DisplayImage() {
        initUI();
    }

    private void initUI() {

        setTitle("Mushrooms");

        add(new Surface());

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayImage ex = new DisplayImage();
                ex.setSize(200, 200);
                ex.setVisible(true);
            }
        });
    }
}