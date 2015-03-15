package com.game.physics;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 21/08/2014
 * {@link http://tutorialswithexamples.com/java-map-and-hashmap-tutorial-with-examples/}
 */

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ball {
    protected float x, y;           // Ball-Center 'X' and 'Y'
    protected float speedX, speedY; // Ball-Speed per step in 'X' and 'Y'
    protected float radius;         // Ball-Radius
    protected Color color;          // Ball-Color
    private   Image mshi;
    public int      soundtrack;
    public int      id;

    public Ball(float x, float y, float radius, float speed, float angleInDegree, Color color, int soundtrack, int id, String image) {
        this.x          = x;
        this.y          = y;
        this.speedX     = (float) (speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY     = (float) (-speed * (float) Math.sin(Math.toRadians(angleInDegree)));
        this.radius     = radius;
        this.color      = color;
//        this.image      = image;
        this.soundtrack = soundtrack;
        this.id         = id;
//        loadImage();
        mshi = new ImageIcon(image).getImage();
    }

    public void update(float incr) {
        this.x += this.speedX * incr;
        this.y += this.speedY * incr;
    }

//    private void loadImage() {
//        mshi = new ImageIcon("images/wait-ball.png").getImage();
//    }

    /**
     * Draw itself using the given graphics context.
     * Клас 'Ball' имеет собственный метод 'draw' который прорисовывает собственный объект...
     * @param g
     */
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255, 255, 255));
//        g2.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
        Image img1 = Toolkit.getDefaultToolkit().getImage("images/wait-ball.png");
        g2.drawImage(mshi, (int)(x-15), (int)(y-15), null);
//        g2.finalize();

        if(id == 0) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 25, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 25, 25);
        }
        if(id == 1) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 125, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 125, 25);
        }
        if(id == 2) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 225, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 225, 25);
        }
        if(id == 3) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 325, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 325, 25);
        }
        if(id == 4) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 425, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 425, 25);
        }
        if(id == 5) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 525, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 525, 25);
        }
        if(id == 6) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 625, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 625, 25);
        }
        if(id == 7) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 725, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 725, 25);
        }
        if(id == 8) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 825, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 825, 25);
        }
        if(id == 9) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 925, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 925, 25);
        }
        if(id == 10) {
            if(((Math.abs(speedX) + Math.abs(speedY))) > 1)
                g2.drawString("[" + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + "]", 1025, 25);
            else
                g2.drawString(" " + new BigDecimal((Math.abs(speedX) + Math.abs(speedY))).setScale(2, RoundingMode.UP).doubleValue() + " ", 1025, 25);
        }
    }

    /**
     * Return mass
     * @return
     */
    public float getMass() {
        return 2 * radius * radius * radius / 1000f;
    }

}

