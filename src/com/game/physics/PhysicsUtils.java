package com.game.physics;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 21/08/2014
 * {@link https://code.google.com/p/java-collision-detection-source-code/source/browse/trunk/Collision-detection-bounce-java/src/PhysicsUtils.java?r=3}
 * **********************************
 * {@link http://bestpupils.ru/stati/150-zadacha-ob-uprugom-stolknovenii-sharov}
 */
import com.game.music.PlayerAdapter;

import java.awt.*;

public class PhysicsUtils {
    /**
     * Мячи талкаются об края борда...
     *
     * @param wall
     * @param ball
     */
    public static void collisionWithWall(Rectangle wall, Ball ball) {
        float ballMinX = wall.x + ball.radius;
        float ballMinY = wall.y + ball.radius;
        float ballMaxX = wall.width - ball.radius;
        float ballMaxY = wall.height - ball.radius;
        if (ball.x < ballMinX) {
            ball.speedX = -ball.speedX; // Отражение вместе нормально
            ball.x      = ballMinX;     // Повторно мяч на краю
            PlayerAdapter.playShock(ball.soundtrack);
        } else if (ball.x > ballMaxX) {
            ball.speedX = -ball.speedX;
            ball.x      = ballMaxX;
            PlayerAdapter.playShock(ball.soundtrack);
        }
        // Может пересечь обе 'X' и 'Y' границы
        if (ball.y < ballMinY) {
            ball.speedY = -ball.speedY;
            ball.y      = ballMinY;
            PlayerAdapter.playShock(ball.soundtrack);
        } else if (ball.y > ballMaxY) {
            ball.speedY = -ball.speedY;
            ball.y      = ballMaxY;
            PlayerAdapter.playShock(ball.soundtrack);
        }
    }

    public static void intersect(Ball a, Ball b) {
        //ref http://gamedev.stackexchange.com/questions/20516/ball-collisions-sticking-together
        double xDist, yDist;
        xDist = a.x - b.x;
        yDist = a.y - b.y;
        double distSquared = xDist * xDist + yDist * yDist;
        // Check the squared distances instead of the the distances, same result, but avoids a square root.
        if (distSquared <= (a.radius + b.radius) * (a.radius + b.radius)) {
            double speedXocity = b.speedX - a.speedX;
            double speedYocity = b.speedY - a.speedY;
            double  dotProduct = xDist * speedXocity + yDist * speedYocity;
            // Neat vector maths, used for checking if the objects moves towards one another.
            if (dotProduct > 0) {
                double   collisionScale = dotProduct / distSquared;
                double       xCollision = xDist * collisionScale;
                double       yCollision = yDist * collisionScale;
                // The Collision vector is the speed difference projected on the Dist vector, thus it is the component of the speed difference needed for the collision.
                double     combinedMass = a.getMass() + b.getMass();
                double collisionWeightA = 2 * b.getMass() / combinedMass;
                double collisionWeightB = 2 * a.getMass() / combinedMass;
                a.speedX += (collisionWeightA * xCollision);
                a.speedY += (collisionWeightA * yCollision);
                b.speedX -= (collisionWeightB * xCollision);
                b.speedY -= (collisionWeightB * yCollision);
                PlayerAdapter.playShock(a.soundtrack);
            }
        }
    }
}