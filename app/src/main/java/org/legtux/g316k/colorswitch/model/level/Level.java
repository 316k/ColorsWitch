package org.legtux.g316k.colorswitch.model.level;

import org.legtux.g316k.colorswitch.model.LevelElement;
import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.item.ChainAndBall;
import org.legtux.g316k.colorswitch.model.item.Item;
import org.legtux.g316k.colorswitch.model.item.JetPack;
import org.legtux.g316k.colorswitch.model.item.Mushroom;
import org.legtux.g316k.colorswitch.model.item.Potion;
import org.legtux.g316k.colorswitch.model.item.Shield;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite pour représenter un niveau.
 *
 */
public abstract class Level {

    /**
     * The actual level value
     */
    protected int level;

    /**
     * À quel point on est avancés dans le level
     */
    protected double scroll;

    /**
     * Dimensions du niveau visible à l'écran
     */
    protected double screenWidth, screenHeight;

    /**
     * nextObstacleItemY[0] : Coordonnées en Y du prochain obstacle
     * nextObstacleItemY[1] : Coordonnées en Y du prochain item
     */
    protected double[] nextObstacleItemY;

    /**
     * coordonnée relative en Y du prochain obstacle
     */
    protected double nextObstacleY;

    /**
     * Obstacles du niveau
     */
    protected List<Obstacle> obstacles;
    /**
     * Items et champignon final
     */
    protected List<Item> items;
    protected Mushroom victoryMushroom;

    public Level(double screenWidth, double screenHeight, int level) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.nextObstacleItemY = new double[2];
        nextObstacleItemY[0] = nextObstacleY * screenHeight;
        nextObstacleItemY[1] = (nextObstacleY + .5) * screenHeight;
        this.nextObstacleY = 0.75;
        this.level = level;

        obstacles = new ArrayList<>();
        items = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public double getScroll() {
        return scroll;
    }

    public double getScreenWidth() {
        return screenWidth;
    }

    public double getScreenHeight() {
        return screenHeight;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Item> getPowerUps() {
        return items;
    }

    public void tick(double dt) {
        for (Obstacle o : obstacles) {
            o.tick(dt);
        }
        for (Item p : items) {
            p.tick(dt);
        }
        if(victoryMushroom != null)
            victoryMushroom.tick(dt);
    }

    public void incrementScroll(double scroll) {
        this.scroll += scroll;
    }

    /**
     * Retourne les entités dans le niveau (obstacles, items et champignon)
     *
     * @return List des entités
     */
    public List<LevelElement> getEntities() {
        List<LevelElement> entities = new ArrayList<>();

        for (LevelElement e : this.obstacles) {
            entities.add(e);
        }
        for (LevelElement e : this.items) {
            entities.add(e);
        }

        if(victoryMushroom != null)
            entities.add(victoryMushroom);

        return entities;
    }

    /**
     * Méthode utilitaire pour aider à la construction de niveau. Retourne la
     * position verticale du prochain obstacle et item à placer.
     */
    public void nextHeightForObstacleAndItem() {
        nextObstacleItemY[0] = nextObstacleY * screenHeight;
        nextObstacleItemY[1] = (nextObstacleY + .5) * screenHeight;
        nextObstacleY += 1;
    }

    /**
     * Méthode utilitaire qui ajoute un item aléatoire basé sur les poids
     * fournit en paramètre. Un poids inférieur à 1 indique que cet item ne doit
     * pas être considéré.
     *
     * @param x coordonnée en x où ajouter l'item
     * @param y coordonnée en y où ajouter l'item
     * @param potionWeight poids associé à la potion
     * @param shieldWeigth poids associé au shield
     * @param jetPackWeight poids associé au jet pack
     * @param chainAndBallWeight poids associé au boulet
     * @param noneWeight poid associé à aucun item.
     */
    public void addRandomItem(double x, double y, int potionWeight, int shieldWeigth,
            int jetPackWeight, int chainAndBallWeight, int noneWeight) {

        int totalWeight = potionWeight + shieldWeigth + jetPackWeight
                + chainAndBallWeight + noneWeight;

        int choice = (int) (Math.random() * totalWeight);

        if (potionWeight > 0 && choice < potionWeight) {
            Potion item = new Potion(x, y);
            items.add(item);
        } else {
            choice -= potionWeight;
            if (shieldWeigth > 0 && choice < shieldWeigth) {
                Shield item = new Shield(x, y);
                items.add(item);
            } else {
                choice -= shieldWeigth;
                if (jetPackWeight > 0 && choice < jetPackWeight) {
                    JetPack item = new JetPack(x, y);
                    items.add(item);
                } else {
                    choice -= jetPackWeight;
                    if (chainAndBallWeight > 0 && choice < chainAndBallWeight) {
                        ChainAndBall item = new ChainAndBall(x, y);
                        items.add(item);
                    }
                }
            }
        }
    }

    /**
     * Ajoute un item sélectionné aléatoirement en utilisant les poids suivants
     * : potion : 1/2; shield, jet pack, chain & ball : 1/6 chacun.
     *
     * @param x coordonnée en x où ajouter l'item
     * @param y coordonnée en y où ajouter l'item
     */
    public void addRandomItem(double x, double y) {
        addRandomItem(x, y, 3, 1, 1, 1, 0);
    }

    /**
     * Une chance sur 12 d'ajouter un item sélectionné aléatoirement en
     * utilisant les poids suivants : potion : 1/2; shield, jet pack, chain &
     * ball : 1/6 chacun.
     *
     * @param x coordonnée en x où ajouter l'item
     * @param y coordonnée en y où ajouter l'item
     */
    public void seldomlyAddRandomItem(double x, double y) {
        addRandomItem(x, y, 3, 1, 1, 1, 66);
    }
}
