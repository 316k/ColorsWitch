package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 9.
 */
public class Level9 extends Level {
    
    /**
     * Constructeur de la classe Level9.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level9(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle01a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 30, 160);
        RotatingCircle obstacle01b = new RotatingCircle(0, nextObstacleItemY[0], 20, x, 2);
        RotatingCircle obstacle01c = new RotatingCircle(2*x, nextObstacleItemY[0], 20, x, 2);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        obstacles.add(obstacle01c);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle02a = new GrowingCircle(x, nextObstacleItemY[0], 20, 100, 100);
        VerticalBar obstacle02b = new VerticalBar(x, nextObstacleItemY[0], 20, 60, 200, screenWidth, -1);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle03a = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, 4);
        Cruncher obstacle03b = new Cruncher(nextObstacleItemY[0], 10, screenWidth, 25, 100, 0);
        RotatingCircle obstacle03c = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, -4);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        obstacles.add(obstacle03c);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle04a = new GrowingCircle(x, nextObstacleItemY[0], 30, x, 10);
        Cruncher obstacle04b = new Cruncher(nextObstacleItemY[0]-30, 10, screenWidth, 20, 250, 0);
        Cruncher obstacle04c = new Cruncher(nextObstacleItemY[0],    10, screenWidth, 40, 300, 0);
        Cruncher obstacle04d = new Cruncher(nextObstacleItemY[0]+30, 10, screenWidth, 20, 250, 0);
        obstacles.add(obstacle04a);
        obstacles.add(obstacle04b);
        obstacles.add(obstacle04c);
        obstacles.add(obstacle04d);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle05a = new VerticalBar(x, nextObstacleItemY[0]-60, 20, 20, -150, screenWidth, -1);
        VerticalBar obstacle05b = new VerticalBar(x, nextObstacleItemY[0]-40, 20, 20, -200, screenWidth, -1);
        VerticalBar obstacle05c = new VerticalBar(x, nextObstacleItemY[0]-20, 20, 20, -250, screenWidth, -1);
        VerticalBar obstacle05d = new VerticalBar(x, nextObstacleItemY[0],    20, 20,  300, screenWidth, -1);
        VerticalBar obstacle05e = new VerticalBar(x, nextObstacleItemY[0]+20, 20, 20,  250, screenWidth, -1);
        VerticalBar obstacle05f = new VerticalBar(x, nextObstacleItemY[0]+40, 20, 20,  200, screenWidth, -1);
        VerticalBar obstacle05g = new VerticalBar(x, nextObstacleItemY[0]+60, 20, 20,  150, screenWidth, -1);
        GrowingCircle obstacle05h = new GrowingCircle(0, nextObstacleItemY[0], 30, x, 10);
        GrowingCircle obstacle05i = new GrowingCircle(2*x, nextObstacleItemY[0], 30, x, 10);
        obstacles.add(obstacle05h);
        obstacles.add(obstacle05i);
        obstacles.add(obstacle05a);
        obstacles.add(obstacle05b);
        obstacles.add(obstacle05c);
        obstacles.add(obstacle05d);
        obstacles.add(obstacle05e);
        obstacles.add(obstacle05f);
        obstacles.add(obstacle05g);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle13a = new GrowingCircle(x, nextObstacleItemY[0], 75, 50, 200);
        RotatingCircle obstacle13b = new RotatingCircle(x, nextObstacleItemY[0], 20, 75, 10);
        RotatingCircle obstacle13c = new RotatingCircle(x, nextObstacleItemY[0], 20, 75, -10);
        RotatingCircle obstacle13d = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, 5);
        RotatingCircle obstacle13e = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, -5);
        obstacles.add(obstacle13a);
        obstacles.add(obstacle13b);
        obstacles.add(obstacle13c);
        obstacles.add(obstacle13d);
        obstacles.add(obstacle13e);

        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
    
}
