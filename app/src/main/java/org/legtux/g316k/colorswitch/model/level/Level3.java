
package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.item.ChainAndBall;
import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.item.Potion;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 3.
 */
public class Level3 extends Level {

    /**
     * Constructeur de la classe Level3.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level3(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        Square obstacle01a = new Square(x, nextObstacleItemY[0], 50);
        RotatingCircle obstacle01b = new RotatingCircle(x, nextObstacleItemY[0],  20, 150, 2);
        Potion item01 = new Potion(x, nextObstacleItemY[1]);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        items.add(item01);

        super.nextHeightForObstacleAndItem();
        Cruncher obstacle02a = new Cruncher(nextObstacleItemY[0], 50, screenWidth, 50, 100, 0);
        VerticalBar obstacle02b = new VerticalBar(x, nextObstacleItemY[0], 10, 100, 150, screenWidth, 1);
        ChainAndBall item02 = new ChainAndBall(x, nextObstacleItemY[1]);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        items.add(item02);
        
        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle03a = new GrowingCircle(screenWidth / 5, nextObstacleItemY[0], 0, 100, 30);
        GrowingCircle obstacle03b = new GrowingCircle(2 * screenWidth / 5, nextObstacleItemY[0], 0, 100, 30);
        GrowingCircle obstacle03c = new GrowingCircle(3 * screenWidth / 5, nextObstacleItemY[0], 0, 100, 30);
        GrowingCircle obstacle03d = new GrowingCircle(4 * screenWidth / 5, nextObstacleItemY[0], 0, 100, 30);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        obstacles.add(obstacle03c);
        obstacles.add(obstacle03d);
        
        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle04a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 20, 50);
        MultiColorBar obstacle04b = new MultiColorBar(x + 10, nextObstacleItemY[0] + 20, screenWidth, 20, 60);
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
