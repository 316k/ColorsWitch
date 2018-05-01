package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 10.
 */
public class Level10 extends Level {

    /**
     * Constructeur de la classe Level10.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level10(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle01a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 30, 110);
        Cruncher obstacle01b = new Cruncher(nextObstacleItemY[0], 10, screenWidth, 25, 100, 0);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle02a = new GrowingCircle(x, nextObstacleItemY[0], 20, 100, 100);
        VerticalBar obstacle02b = new VerticalBar(x, nextObstacleItemY[0], 20, 60, 200, screenWidth, -1);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

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
        RotatingCircle obstacle05b = new RotatingCircle(0, nextObstacleItemY[0], 20, x, 3);
        RotatingCircle obstacle05c = new RotatingCircle(2*x, nextObstacleItemY[0], 20, x, -3);
        Cruncher obstacle05d = new Cruncher(nextObstacleItemY[0], 10, screenWidth, 50, 150, 0);
        obstacles.add(obstacle05a);
        obstacles.add(obstacle05b);
        obstacles.add(obstacle05c);
        obstacles.add(obstacle05d);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        Cruncher obstacle06a = new Cruncher(nextObstacleItemY[0]-20, 40, screenWidth, 10, 50, 0);
        MultiColorBar obstacle06b = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 40, 100);
        Cruncher obstacle06d = new Cruncher(nextObstacleItemY[0]+20, 40, screenWidth, 10, 50, 0);
        obstacles.add(obstacle06a);
        obstacles.add(obstacle06b);
        obstacles.add(obstacle06d);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle07a = new GrowingCircle(x, nextObstacleItemY[0], 30, 100, 60);
        GrowingCircle obstacle07b = new GrowingCircle(0, nextObstacleItemY[0], 60, x, 40);
        GrowingCircle obstacle07c = new GrowingCircle(2*x, nextObstacleItemY[0], 60, x, 40);
        obstacles.add(obstacle07a);
        obstacles.add(obstacle07b);
        obstacles.add(obstacle07c);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle08a = new GrowingCircle(x, nextObstacleItemY[0], 30, 100, 60);
        GrowingCircle obstacle08b = new GrowingCircle(0, nextObstacleItemY[0], 20, x, 40);
        GrowingCircle obstacle08c = new GrowingCircle(2*x, nextObstacleItemY[0], 20, x, 40);
        RotatingCircle obstacle08d = new RotatingCircle(0, nextObstacleItemY[0], 20, x, 1.5);
        RotatingCircle obstacle08e = new RotatingCircle(2*x, nextObstacleItemY[0], 20, x, -1.5);
        obstacles.add(obstacle08a);
        obstacles.add(obstacle08b);
        obstacles.add(obstacle08c);
        obstacles.add(obstacle08d);
        obstacles.add(obstacle08e);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle09a = new VerticalBar(x, nextObstacleItemY[0]-60, 20, 20, 150, screenWidth, -1);
        VerticalBar obstacle09b = new VerticalBar(x, nextObstacleItemY[0]-40, 20, 20, 200, screenWidth, -1);
        VerticalBar obstacle09c = new VerticalBar(x, nextObstacleItemY[0]-20, 20, 20, 250, screenWidth, -1);
        VerticalBar obstacle09d = new VerticalBar(x, nextObstacleItemY[0],    20, 20, 300, screenWidth, -1);
        VerticalBar obstacle09e = new VerticalBar(x, nextObstacleItemY[0]+20, 20, 20, 250, screenWidth, -1);
        VerticalBar obstacle09f = new VerticalBar(x, nextObstacleItemY[0]+40, 20, 20, 200, screenWidth, -1);
        VerticalBar obstacle09g = new VerticalBar(x, nextObstacleItemY[0]+60, 20, 20, 150, screenWidth, -1);
        obstacles.add(obstacle09a);
        obstacles.add(obstacle09b);
        obstacles.add(obstacle09c);
        obstacles.add(obstacle09d);
        obstacles.add(obstacle09e);
        obstacles.add(obstacle09f);
        obstacles.add(obstacle09g);
        addRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle10a = new VerticalBar(x, nextObstacleItemY[0]-60, 20, 20, -150, screenWidth, -1);
        VerticalBar obstacle10b = new VerticalBar(x, nextObstacleItemY[0]-40, 20, 20, -200, screenWidth, -1);
        VerticalBar obstacle10c = new VerticalBar(x, nextObstacleItemY[0]-20, 20, 20, -250, screenWidth, -1);
        VerticalBar obstacle10d = new VerticalBar(x, nextObstacleItemY[0],    20, 20,  300, screenWidth, -1);
        VerticalBar obstacle10e = new VerticalBar(x, nextObstacleItemY[0]+20, 20, 20,  250, screenWidth, -1);
        VerticalBar obstacle10f = new VerticalBar(x, nextObstacleItemY[0]+40, 20, 20,  200, screenWidth, -1);
        VerticalBar obstacle10g = new VerticalBar(x, nextObstacleItemY[0]+60, 20, 20,  150, screenWidth, -1);
        obstacles.add(obstacle10a);
        obstacles.add(obstacle10b);
        obstacles.add(obstacle10c);
        obstacles.add(obstacle10d);
        obstacles.add(obstacle10e);
        obstacles.add(obstacle10f);
        obstacles.add(obstacle10g);
        seldomlyAddRandomItem(x, nextObstacleItemY[1]);

        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle13 = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 40, 100);
        GrowingCircle obstacle13a = new GrowingCircle(x, nextObstacleItemY[0], 75, 50, 200);
        RotatingCircle obstacle13b = new RotatingCircle(x, nextObstacleItemY[0], 20, 75, 7.5);
        RotatingCircle obstacle13c = new RotatingCircle(x, nextObstacleItemY[0], 20, 75, -7.5);
        RotatingCircle obstacle13d = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, 3.5);
        RotatingCircle obstacle13e = new RotatingCircle(x, nextObstacleItemY[0], 20, 100, -3.5);
        obstacles.add(obstacle13);
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
