package com.game;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 21/08/2014
 * {@link https://code.google.com/p/java-collision-detection-source-code/source/browse/trunk/Collision-detection-bounce-java/src/CollisionBouncePanel.java?r=3}
 * **********************************
 * {@link http://bestpupils.ru/stati/150-zadacha-ob-uprugom-stolknovenii-sharov}
 */

import com.game.physics.Ball;
import com.game.physics.Board;
import com.game.physics.PhysicsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class GameStage extends JPanel {
    /**
     * Этот класс прорисовывает всех участников игры.
     * Предварительно выполняется иннициализация игрового поля, положения и цвета для игровых объектов.
     */
    List<Ball>         balls = new ArrayList<Ball>();
    private Board      board;
    private DrawCanvas canvas;
    private int        canvasWidth;
    private int        canvasHeight;
    private double     slipping = 1.0; //private double     slipping = 50.0;



    public GameStage(int width, int height) {
//        try {
//            PrintStream printStream = new PrintStream(new FileOutputStream("CollisionBouncePanel.txt", true), true);
//            printStream.println("Start the ball bouncing");
//            printStream.close();
//        } catch (IOException e) { e.printStackTrace(); }

        canvasWidth  = width;
        canvasHeight = height;
        // init balls
        balls.add(new Ball(1490, 354, 16, 0.5F, 0, Color.BLUE, 50, 0, "images/wait-ball.png")); //balls.add(new Ball(1490, 354, 16, 5.5F, 0, Color.BLUE, 50, 0, "images/wait-ball.png"));
        balls.add(new Ball(310, 354, 16, 0, 0, Color.CYAN, 50, 1, "images/magento3-ball.png"));
        balls.add(new Ball(280, 337, 16, 0, 0, Color.GRAY, 50, 2, "images/magento3-ball.png"));
        balls.add(new Ball(280, 371, 16, 0, 0, Color.ORANGE, 50, 3, "images/magento3-ball.png"));
        balls.add(new Ball(250, 320, 16, 0, 0, Color.YELLOW, 50, 4, "images/magento3-ball.png"));
        balls.add(new Ball(250, 354, 16, 0, 0, Color.YELLOW, 50, 5, "images/magento3-ball.png"));
        balls.add(new Ball(250, 388, 16, 0, 0, Color.GREEN, 50, 6, "images/magento3-ball.png"));
        balls.add(new Ball(220, 303, 16, 0, 0, Color.BLUE, 50, 7, "images/magento3-ball.png"));
        balls.add(new Ball(220, 337, 16, 0, 0, Color.PINK, 50, 8, "images/magento3-ball.png"));
        balls.add(new Ball(220, 371, 16, 0, 0, Color.PINK, 50, 9, "images/magento3-ball.png"));
        balls.add(new Ball(220, 405, 16, 0, 0, Color.GREEN, 50, 10, "images/magento3-ball.png"));

        board  = new Board(0, 0, canvasWidth, canvasHeight, new Color(0, 70, 0), new Color(100, 75, 0));
        canvas = new DrawCanvas();

        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        // Handling window resize. Adjust container box to fill the screen.
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component сomponent = (Component) e.getSource();
                Dimension dimension = сomponent.getSize();
                board.set(0, 0, dimension.width, dimension.height);
            }
        });
    }

    /**
     * Начните мяч отскакивая.
     */
    public void gameStart() {
        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    gameUpdate(false);
                    repaint();
                    // Delay and give other thread a chance
                    try {
                        Thread.sleep((int)slipping);
//                        slipping += (slipping*0.01);
                    } catch (InterruptedException ex) {}
                }
//                System.out.println("> (3) Игра окончена -> освобождаю рессурсы...");
//                PlayerAdapter.close();
            }
        };
        gameThread.start(); // Invoke GaemThread.run()
    }

    /**
     * обнаруживает столкновение, отскоки, рассчитать конечные скорости
     * @param isStriker
     */
    public void gameUpdate(boolean isStriker) {
        // Проверьте столкновения между шариками и коробки
        for (int i = 0; i < balls.size(); i++) {
            PhysicsUtils.collisionWithWall(new Rectangle((board.minX+90), (board.minY+79), (board.maxX-90), (board.maxY-55)), balls.get(i));
        }
        // Проверьте столкновения между двумя шарами
        for (int i = 0; i < balls.size(); i++) {
            for (int j = 0; j < balls.size(); j++) {
                if (i < j) {
                    PhysicsUtils.intersect(balls.get(i), balls.get(j));
                }
            }
        }
        // update positions increments
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).update(1);
        }
    }

    /** The custom drawing panel for the bouncing ball (inner class). */
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            // Draw the balls and field
            board.draw(g2);
            for (Ball ball : balls) {
                ball.draw(g2);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}

