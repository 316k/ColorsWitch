package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.item.Potion;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;

/**
 * Classe du niveau 5.
 */
public class Level5 extends Level {
    
    /**
     * Constructeur de la classe Level5.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level5(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        Cruncher obstacle01a = new Cruncher(nextObstacleItemY[0], 20, screenWidth, 30, 200, 0);
        Cruncher obstacle01b = new Cruncher(nextObstacleItemY[0], 20, screenWidth, 20, 250, -1);
        Cruncher obstacle01c = new Cruncher(nextObstacleItemY[0], 20, screenWidth, 10, 300, 1);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        obstacles.add(obstacle01c);
        
        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle02a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 10, 50);
        MultiColorBar obstacle02b = new MultiColorBar(x + 10, nextObstacleItemY[0] + 150, screenWidth, 10, 60);
        MultiColorBar obstacle02c = new MultiColorBar(x + 20, nextObstacleItemY[0] + 300, screenWidth, 10, 80);
        MultiColorBar obstacle02d = new MultiColorBar(x + 20, nextObstacleItemY[0] + 450, screenWidth, 10, 80);
        Potion item02a = new Potion(x, nextObstacleItemY[0] + 75);
        Potion item02b = new Potion(x, nextObstacleItemY[0] + 225);
        Potion item02c = new Potion(x, nextObstacleItemY[0] + 400);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        obstacles.add(obstacle02c);
        obstacles.add(obstacle02d);
        items.add(item02a);
        items.add(item02b);
        items.add(item02c);

        super.nextHeightForObstacleAndItem();
        Cruncher obstacle03a = new Cruncher(nextObstacleItemY[0] + 100, 20, screenWidth, 30, 200, -1);
        Cruncher obstacle03b = new Cruncher(nextObstacleItemY[0] + 150, 20, screenWidth, 20, 250, 0);
        Cruncher obstacle03c = new Cruncher(nextObstacleItemY[0] + 200, 20, screenWidth, 10, 300, 1);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        obstacles.add(obstacle03c);

        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle04a = new RotatingCircle(x, nextObstacleItemY[0], 20, 70, 2);
        RotatingCircle obstacle04b = new RotatingCircle(x, nextObstacleItemY[0], 30, 100, 3);
        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        obstacles.add(obstacle04a);
        obstacles.add(obstacle04b);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
    
}
