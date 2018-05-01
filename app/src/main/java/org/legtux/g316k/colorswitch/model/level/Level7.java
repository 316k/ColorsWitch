package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 7.
 */
public class Level7 extends Level {
    
    /**
     * Constructeur de la classe Level7.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level7(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle01a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 60, 80);
        VerticalBar obstacle01b = new VerticalBar(x, nextObstacleItemY[0], 40, 60, 120, screenWidth, -1);
        VerticalBar obstacle01c = new VerticalBar(x, nextObstacleItemY[0], 40, 60, 30, screenWidth, -1);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        obstacles.add(obstacle01c);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle02a = new VerticalBar(x, nextObstacleItemY[0]-60, 20, 20, 150, screenWidth, -1);
        VerticalBar obstacle02b = new VerticalBar(x, nextObstacleItemY[0]-40, 20, 20, 200, screenWidth, -1);
        VerticalBar obstacle02c = new VerticalBar(x, nextObstacleItemY[0]-20, 20, 20, 250, screenWidth, -1);
        VerticalBar obstacle02d = new VerticalBar(x, nextObstacleItemY[0],    20, 20, 300, screenWidth, -1);
        VerticalBar obstacle02e = new VerticalBar(x, nextObstacleItemY[0]+20, 20, 20, 250, screenWidth, -1);
        VerticalBar obstacle02f = new VerticalBar(x, nextObstacleItemY[0]+40, 20, 20, 200, screenWidth, -1);
        VerticalBar obstacle02g = new VerticalBar(x, nextObstacleItemY[0]+60, 20, 20, 150, screenWidth, -1);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        obstacles.add(obstacle02c);
        obstacles.add(obstacle02d);
        obstacles.add(obstacle02e);
        obstacles.add(obstacle02f);
        obstacles.add(obstacle02g);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle03a = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, 10);
        Cruncher obstacle03b = new Cruncher(nextObstacleItemY[0], 10, screenWidth, 25, 100, 0);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle04a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 30, 160);
        RotatingCircle obstacle04b = new RotatingCircle(0, nextObstacleItemY[0], 20, 100, 10);
        RotatingCircle obstacle04c = new RotatingCircle(2*x, nextObstacleItemY[0], 20, 100, 10);
        obstacles.add(obstacle04a);
        obstacles.add(obstacle04b);
        obstacles.add(obstacle04c);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        Square obstacle05a = new Square(x, nextObstacleItemY[0], 150);
        RotatingCircle obstacle05b = new RotatingCircle(0, nextObstacleItemY[0], 20, x, 2);
        RotatingCircle obstacle05c = new RotatingCircle(2*x, nextObstacleItemY[0], 20, x, -2);
        Cruncher obstacle05d = new Cruncher(nextObstacleItemY[0], 10, screenWidth, 50, 150, 0);
        obstacles.add(obstacle05a);
        obstacles.add(obstacle05b);
        obstacles.add(obstacle05c);
        obstacles.add(obstacle05d);
        addRandomItem(x, nextObstacleItemY[1]);


        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle06a = new GrowingCircle(x, nextObstacleItemY[0], 75, 50, 200);
        obstacles.add(obstacle06a);

        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
    
}
