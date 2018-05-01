package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.item.JetPack;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.RotatingCircle;
import org.legtux.g316k.colorswitch.model.item.Shield;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 4.
 */
public class Level4 extends Level {
    
    /**
     * Constructeur de la classe Level4.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level4(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        Shield item01 = new Shield(x, nextObstacleItemY[0]);
        GrowingCircle obstacle01a = new GrowingCircle(screenWidth / 4, nextObstacleItemY[0], 0, 100, 30);
        GrowingCircle obstacle01b = new GrowingCircle(3 * screenWidth / 4, nextObstacleItemY[0], 0, 100, 30);
        GrowingCircle obstacle01c = new GrowingCircle(screenWidth / 2, nextObstacleItemY[0] + 50, 0, 100, 30);
        GrowingCircle obstacle01d = new GrowingCircle(screenWidth / 4, nextObstacleItemY[0] + 50, 0, 100, 30);
        GrowingCircle obstacle01e = new GrowingCircle(3 * screenWidth / 4, nextObstacleItemY[0] +50, 0, 100, 30);
        GrowingCircle obstacle01f = new GrowingCircle(screenWidth / 2, nextObstacleItemY[0] + 100, 0, 100, 30);
        GrowingCircle obstacle01g = new GrowingCircle(screenWidth / 4, nextObstacleItemY[0] + 100, 0, 100, 30);
        GrowingCircle obstacle01h = new GrowingCircle(3 * screenWidth / 4, nextObstacleItemY[0] + 100, 0, 100, 30);
        GrowingCircle obstacle01i = new GrowingCircle(screenWidth / 2, nextObstacleItemY[0] + 150, 0, 100, 30);
        GrowingCircle obstacle01j = new GrowingCircle(screenWidth / 4, nextObstacleItemY[0] + 150, 0, 100, 30);
        GrowingCircle obstacle01k = new GrowingCircle(3 * screenWidth / 4, nextObstacleItemY[0] + 150, 0, 100, 30);
        GrowingCircle obstacle01l = new GrowingCircle(screenWidth / 2, nextObstacleItemY[0] + 200, 0, 100, 30);
        GrowingCircle obstacle01m = new GrowingCircle(screenWidth / 4, nextObstacleItemY[0] + 250, 0, 100, 30);
        GrowingCircle obstacle01n = new GrowingCircle(3 * screenWidth / 4, nextObstacleItemY[0] + 250, 0, 100, 30);
        GrowingCircle obstacle01o = new GrowingCircle(screenWidth / 2, nextObstacleItemY[0] + 200, 0, 300, 30);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        obstacles.add(obstacle01c);
        obstacles.add(obstacle01d);
        obstacles.add(obstacle01e);
        obstacles.add(obstacle01f);
        obstacles.add(obstacle01g);
        obstacles.add(obstacle01h);
        obstacles.add(obstacle01i);
        obstacles.add(obstacle01j);
        obstacles.add(obstacle01k);
        obstacles.add(obstacle01l);
        obstacles.add(obstacle01m);
        obstacles.add(obstacle01n);
        obstacles.add(obstacle01o);
        items.add(item01);
        
        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle02a = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 20, 50);
        MultiColorBar obstacle02b = new MultiColorBar(x + 10, nextObstacleItemY[0] + 25, screenWidth, 20, 60);
        MultiColorBar obstacle02c = new MultiColorBar(x + 10, nextObstacleItemY[0] + 50, screenWidth, 20, 80);
        RotatingCircle obstacle02d = new RotatingCircle(x, nextObstacleItemY[1],  30, 100, 4);
        JetPack item02 = new JetPack(x, nextObstacleItemY[1]);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        obstacles.add(obstacle02a);
        obstacles.add(obstacle02b);
        obstacles.add(obstacle02c);
        obstacles.add(obstacle02d);
        items.add(item02);
        
        super.nextHeightForObstacleAndItem();
        RotatingCircle obstacle03a = new RotatingCircle(x, nextObstacleItemY[0],  20, 100, 4);
        RotatingCircle obstacle03b = new RotatingCircle(x + 50, nextObstacleItemY[0],  30, 100, 3);
        RotatingCircle obstacle03c = new RotatingCircle(x - 50, nextObstacleItemY[0],  20, 100, 4);
        RotatingCircle obstacle03d = new RotatingCircle(x, nextObstacleItemY[0] + 100,  30, 100, 2);
        obstacles.add(obstacle03a);
        obstacles.add(obstacle03b);
        obstacles.add(obstacle03c);
        obstacles.add(obstacle03d);
        
        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle04a = new VerticalBar(x, nextObstacleItemY[0], 10, 50, 20, screenWidth, 1);
        VerticalBar obstacle04b = new VerticalBar(x, nextObstacleItemY[0] + 50, 10, 50, 40, screenWidth, 2);
        VerticalBar obstacle04c = new VerticalBar(x, nextObstacleItemY[0] + 100, 10, 50, 60, screenWidth, 3);
        VerticalBar obstacle04d = new VerticalBar(x, nextObstacleItemY[0] + 150, 10, 50, 80, screenWidth, 0);
        VerticalBar obstacle04e = new VerticalBar(x, nextObstacleItemY[0] + 200, 10, 50, 100, screenWidth, 1);
        VerticalBar obstacle04f = new VerticalBar(x, nextObstacleItemY[0] + 250, 10, 50, 120, screenWidth, 2);
        VerticalBar obstacle04g = new VerticalBar(x, nextObstacleItemY[0] + 300, 10, 50, 140, screenWidth, 3);
        VerticalBar obstacle04h = new VerticalBar(x, nextObstacleItemY[0] + 350, 10, 50, 160, screenWidth, 0);
        VerticalBar obstacle04i = new VerticalBar(x, nextObstacleItemY[0] + 400, 10, 50, 180, screenWidth, 1);
        obstacles.add(obstacle04a);
        obstacles.add(obstacle04b);
        obstacles.add(obstacle04c);
        obstacles.add(obstacle04d);
        obstacles.add(obstacle04e);
        obstacles.add(obstacle04f);
        obstacles.add(obstacle04g);
        obstacles.add(obstacle04h);
        obstacles.add(obstacle04i);

        super.nextHeightForObstacleAndItem();
        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
    
}
