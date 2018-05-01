package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.item.ChainAndBall;
import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.obstacle.GrowingCircle;
import org.legtux.g316k.colorswitch.model.item.JetPack;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.obstacle.Square;
import org.legtux.g316k.colorswitch.model.obstacle.VerticalBar;

/**
 * Classe du niveau 2.
 */
public class Level2 extends Level {

    /**
     * Constructeur de la classe Level2.
     * 
     * @param screenWidth La largeur de l'écran
     * @param screenHeight La hauteur de l'écran
     * @param level Le niveau
     */
    public Level2(double screenWidth, double screenHeight, int level) {
        super(screenWidth, screenHeight, level);

        double x = screenWidth / 2;

        super.nextHeightForObstacleAndItem();
        VerticalBar obstacle01a = new VerticalBar(x, nextObstacleItemY[0], 10, 80, 100, screenWidth, 2);
        VerticalBar obstacle01b = new VerticalBar(x + 20, nextObstacleItemY[0] + 50, 10, 80, 150, screenWidth, 3);
        JetPack item01 = new JetPack(x, nextObstacleItemY[1]);
        obstacles.add(obstacle01a);
        obstacles.add(obstacle01b);
        items.add(item01);
        
        super.nextHeightForObstacleAndItem();
        GrowingCircle obstacle02 = new GrowingCircle(x, nextObstacleItemY[0], 0, 100, 30);
        ChainAndBall item02 = new ChainAndBall(x, nextObstacleItemY[1]);
        obstacles.add(obstacle02);
        items.add(item02);
        
        super.nextHeightForObstacleAndItem();
        Cruncher obstacle03 = new Cruncher(nextObstacleItemY[0], 50, screenWidth, 100, 100, 0);
        obstacles.add(obstacle03);
        
        super.nextHeightForObstacleAndItem();
        MultiColorBar obstacle04 = new MultiColorBar(x, nextObstacleItemY[0], screenWidth, 80, 50);
        obstacles.add(obstacle04);
        obstacles.add(obstacle04);
        
        super.nextHeightForObstacleAndItem();
        victoryMushroom = new Mushroom(x, nextObstacleItemY[0]);
        
        // protection against the JetPack
        super.nextHeightForObstacleAndItem();
        super.nextHeightForObstacleAndItem();
        Square obstacleLast = new Square(x, nextObstacleItemY[0], 3*x);
        obstacles.add(obstacleLast);
    }
}
