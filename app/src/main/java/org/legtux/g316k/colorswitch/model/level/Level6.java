package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 6.
 */
public class Level6 extends Level {
    
    /**
     * Constructeur de la classe Level6.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level6(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle01a = new MultiColorBar(x, nextObstacleItemY[0]-10, screenWidth, 10, 80);
        MultiColorBar obstacle01b = new MultiColorBar(x, nextObstacleItemY[0]+10, screenWidth, 10, -80);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        addRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle02a = new GrowingCircle(x, nextObstacleItemY[0], 50, 30, 200);
        RotatingCircle obstacle02b = new RotatingCircle(x, nextObstacleItemY[0],  20, 60, 3);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle03a = new RotatingCircle(0, nextObstacleItemY[0],  20, x, 2.5);
        RotatingCircle obstacle03b = new RotatingCircle(2*x, nextObstacleItemY[0],  20, x, 3);
        Square obstacle03c = new Square(x, nextObstacleItemY[0], 150);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        obstacles.add(obstacle03c);
        addRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        Cruncher obstacle04a = new Cruncher(nextObstacleItemY[0] - 60, x/4, screenWidth, 50, 150, -1);
        Cruncher obstacle04b = new Cruncher(nextObstacleItemY[0], x/4, screenWidth, 50, 100, 0);
        Cruncher obstacle04c = new Cruncher(nextObstacleItemY[0] + 60, x/4, screenWidth, 50, 150, 1);
        obstacles.add(obstacle04a);
        obstacles.add(obstacle04b);
        obstacles.add(obstacle04c);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle05a = new GrowingCircle(0, nextObstacleItemY[0], 50, x, 150);
        GrowingCircle obstacle05b = new GrowingCircle(2*x, nextObstacleItemY[0], 50, x, 150);
        Cruncher obstacle05c = new Cruncher(nextObstacleItemY[0], x/4, screenWidth, 50, 100, 0);
        obstacles.add(obstacle05a);
        obstacles.add(obstacle05b);
        obstacles.add(obstacle05c);
        addRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle06a = new RotatingCircle(2*x/5, nextObstacleItemY[0],  20, 60, 3);
        RotatingCircle obstacle06b = new RotatingCircle(4*x/5, nextObstacleItemY[0],  20, 60, 3);
        RotatingCircle obstacle06c = new RotatingCircle(6*x/5, nextObstacleItemY[0],  20, 60, 3);
        RotatingCircle obstacle06d = new RotatingCircle(8*x/5, nextObstacleItemY[0],  20, 60, 3);
        obstacles.add(obstacle06a);
        obstacles.add(obstacle06b);
        obstacles.add(obstacle06c);
        obstacles.add(obstacle06d);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle07a = new VerticalBar(x, nextObstacleItemY[0]-60, 40, 60, 60, screenWidth, -1);
        VerticalBar obstacle07b = new VerticalBar(x, nextObstacleItemY[0]-30, 40, 60, 120, screenWidth, -1);
        VerticalBar obstacle07c = new VerticalBar(x, nextObstacleItemY[0]+30, 40, 60, 180, screenWidth, -1);
        VerticalBar obstacle07d = new VerticalBar(x, nextObstacleItemY[0]+60, 40, 60, 200, screenWidth, -1);
        obstacles.add(obstacle07a);
        obstacles.add(obstacle07b);
        obstacles.add(obstacle07c);
        obstacles.add(obstacle07d);
        addRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle08a = new RotatingCircle(0, nextObstacleItemY[0],  20, x, 3);
        GrowingCircle obstacle08b = new GrowingCircle(2*x, nextObstacleItemY[0], 50, x, 100);
        MultiColorBar obstacle08c = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 30, -150);
        obstacles.add(obstacle08a);
        obstacles.add(obstacle08b);
        obstacles.add(obstacle08c);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);
        
        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle09 = new GrowingCircle(x, nextObstacleItemY[0], 75, 50, 200);
        obstacles.add(obstacle09);

        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
    
}
