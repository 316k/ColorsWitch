package org.legtux.g316k.colorswitch.model.obstacle;

import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.MultiColorBarRenderer;

/**
 * Obstacle : barre horizontale divisée en quatre sections
 * de couleurs différentes qui défilent comme une visse sans fin.
 */
public class MultiColorBar extends Obstacle {

    private final double totalWidth;
    private final double sectionWidth;
    private final double height;
    private final double vx;
    private final double[] xArray;
    private final int[] colorArray;

    /**
     * Instancie un MultiColorBar
     * 
     * @param x coordonnée en x de la première section
     * @param y coordonnée en y de la barre
     * @param largeur largeur de la barre
     * @param hauteur hauteur de la barre
     * @param vitesse vitesse de défilement des sections de couleur
     */
    public MultiColorBar(double x, double y, double largeur, double hauteur, double vitesse) {
        super(x, y);

        this.totalWidth = largeur;
        this.sectionWidth = largeur / 4;
        this.height = hauteur;
        this.vx = vitesse;

        this.renderer = new MultiColorBarRenderer(this);

        this.color = 1;

        this.xArray = new double[4];
        this.colorArray = new int[4];
        for (int i = 0; i < 4; i++) {
            xArray[i] = (x + i * this.sectionWidth) % this.totalWidth;
            colorArray[i] = (color + i) % 4;
        }
    }

    
    /**
     * Donne la coordonnée en x du centre de chaque section.
     * 
     * @return un tableau de 4 coordonnées
     */
    public final double[] getAllX() {
        return xArray;
    }

    
    /**
     * Donne la couleur de toutes les sections.
     * 
     * @return un tableau de 4 couleur indexées
     */
    public final int[] getAllColor() {
        return colorArray;
    }

    
    /**
     * Retourne la largeur d'une section.
     * 
     * @return la largeur en pixel
     */
    @Override
    public double getWidth() {
        return sectionWidth;
    }

    
    /**
     * Retourne la hauteur de la barre.
     * 
     * @return la hauteur en pixel
     */
    @Override
    public double getHeight() {
        return height;
    }

    
    /**
     * Appelée à chaque tick, fait déplacé chaque section au sein de la
     * barre. Une section sortant par une extrémité, rentre par l'autre.
     * 
     * @param dt la variation de temps écoulée
     */
    @Override
    public void tick(double dt) {
        x += dt * vx;

        if (x < 0) {
            x = totalWidth + x;
        }
        
        for (int i = 0; i < 4; i++) {
            xArray[i] = (x + i * sectionWidth) % totalWidth;
            colorArray[i] = (color + i) % 4;
        }
    }

    
    /**
     * Détermine s'il y a intersection entre le joueur et la barre.
     * 
     * @param player le joueur
     * @return true s'il y a intersection
     */
    @Override
    public boolean intersects(Player player) {

        boolean result = false;
        
        for (int i = 0; i < 4; i++) {
            result = result
                    || (colorArray[i] != player.getColor()
                    && player.getWestBorder() < xArray[i] + this.getWidth() / 2
                    && player.getEastBorder() > xArray[i] - this.getWidth() / 2
                    && player.getSouthBorder() < this.getY() + this.getHeight() / 2
                    && player.getNorthBorder() > this.getY() - this.getHeight() / 2);
        }
        
        return result;
    }

}
