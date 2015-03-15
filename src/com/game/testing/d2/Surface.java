package com.game.testing.d2;

/**
 * Created with IntelliJ IDEA.
 * User: artur
 * Date: 01.09.14
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    private Image mshi;

    public Surface() {
        loadImage();
//        setSurfaceSize();
    }

    private void loadImage() {
        mshi = new ImageIcon("images/balls-billiard.png").getImage();
    }

//    private void setSurfaceSize() {
//        Dimension d = new Dimension();
//        d.width = mshi.getWidth(null);
//        d.height = mshi.getHeight(null);
////        setPreferredSize(d);
//    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(mshi, 1, 1, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}
