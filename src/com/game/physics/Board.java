package com.game.physics;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 21/08/2014
 * {@link https://code.google.com/p/java-collision-detection-source-code/source/browse/trunk/Collision-detection-bounce-java/src/GameField.java?r=3}
 * **********************************
 * {@link http://bestpupils.ru/stati/150-zadacha-ob-uprugom-stolknovenii-sharov}
 */

import javax.swing.*;
import java.awt.*;

public class Board {
    /**
     * Этот класс прорисовывает игровое поле
     */
    public int minX, maxX, minY, maxY;
    private Color colorFilled;
    private Color colorBorder;
    private Image mshi;
    private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
    private static final Color DEFAULT_COLOR_BORDER = Color.YELLOW;
    public static final int          goalPostRadius = 100;

    public Board(int x, int y, int width, int height, Color colorFilled, Color colorBorder) {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
        this.colorFilled = colorFilled;
        this.colorBorder = colorBorder;
        mshi = new ImageIcon("images/table-billiard.png").getImage();
    }

    public Board(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR_FILLED, DEFAULT_COLOR_BORDER);
    }

    public void set(int x, int y, int width, int height) {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Image img1 = Toolkit.getDefaultToolkit().getImage("images/table-billiard.png");
        g2.drawImage(mshi, minX, minY, null);
    }

}

