package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.item.Potion;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.item.Shield;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 1.
 */
public class Level1 extends Level {

    /**
     * Constructeur de la classe Level1.
     *
     * @param screenWidth  La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level        Le niveau
     */
    public Level1(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);
/*

        for (int i = 0; i < 20; i++) {
            Square sq = new Square(screenWidth - 40, screenHeight * 0.3 * i, screenHeight * 0.15);
            obstacles.add(sq);
        }
*/
        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        Square obstacle01 = new Square(x, nextObstacleItemY[0], 40);
        Potion item01 = new Potion(x, nextObstacleItemY[1]);
        obstacles.add(obstacle01);
        items.add(item01);
        
        super.nextHeightForObstacleAndItem();

        VerticalBar obstacle02 = new VerticalBar(x, nextObstacleItemY[0], 10, 80, 100, screenWidth, 2);
        Shield item02 = new Shield(x, nextObstacleItemY[1]);
        items.add(item02);
        obstacles.add(obstacle02);

        super.nextHeightForObstacleAndItem();
        Square obstacle03 = new Square(x, nextObstacleItemY[0], 200);
        obstacles.add(obstacle03);
        
        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle04a = new RotatingCircle(x, nextObstacleItemY[0],  20, 100, 2);
        RotatingCircle obstacle04b = new RotatingCircle(x, nextObstacleItemY[0] + 100,  20, 100, 4);
        obstacles.add(obstacle04a);
        obstacles.add(obstacle04b);
        
        super.nextHeightForObstacleAndItem();
        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
}
