package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;

/**
 * Classe du niveau 8.
 */
public class Level8 extends Level {
    
    /**
     * Constructeur de la classe Level8.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level8(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle1a = new MultiColorBar(x, nextObstacleItemY[0]-5, screenWidth, 10, 80);
        MultiColorBar obstacle1b = new MultiColorBar(x, nextObstacleItemY[0]+5, screenWidth, 10, -80);
        obstacles.add(obstacle1a);
        obstacles.add(obstacle1b);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        Cruncher obstacle02a = new Cruncher(nextObstacleItemY[0]-20, 40, screenWidth, 10, 100, 0);
        MultiColorBar obstacle02b = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 40, 100);
        RotatingCircle obstacle02c = new RotatingCircle(x, nextObstacleItemY[0],  10, 120, 2.5);
        Cruncher obstacle02d = new Cruncher(nextObstacleItemY[0]+20, 40, screenWidth, 10, 100, 0);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        obstacles.add(obstacle02c);
        obstacles.add(obstacle02d);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle03a = new GrowingCircle(x, nextObstacleItemY[0], 30, 100, 100);
        GrowingCircle obstacle03b = new GrowingCircle(0, nextObstacleItemY[0], 20, x, 200);
        GrowingCircle obstacle03c = new GrowingCircle(2*x, nextObstacleItemY[0], 20, x, 200);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        obstacles.add(obstacle03c);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);


        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle05a = new GrowingCircle(x, nextObstacleItemY[0], 75, 50, 200);
        obstacles.add(obstacle05a);

        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
    
}
