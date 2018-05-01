package org.legtux.g316k.colorswitch.model.obstacle;

import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.RectangleRenderer;

/**
 * Obstacle : rectangle vertical de couleur invariable, mais
 * qui se déplace de gauche à droite avec le temps.
 */
public class VerticalBar extends Obstacle {

    private final double width;
    private final double height;
    private final double screenwidth;
    private double vx;
    
    /**
     * Constructeur de la classe VerticalBar.
     * 
     * @param x La coordonnée en x
     * @param y La coordonnée en y
     * @param largeur La largeur de la barre verticale
     * @param hauteur La hauteur de la barre verticale
     * @param vitesse La vitesse de déplacement
     * @param screenwidth La largeur de l'écran
     * @param color La couleur de la barre verticale
     */
    public VerticalBar(double x, double y, double largeur, double hauteur, 
        double vitesse, double screenwidth, int color) {
        
        super(x, y);

        this.width = largeur;
        this.height = hauteur;
        this.vx = vitesse;
        this.screenwidth = screenwidth;

        this.renderer = new RectangleRenderer(this);

        this.color = (color < 0) ? (int) (Math.random() * 4) : color;
    }
    
    
    /**
     * Accesseur de la largeur de la barre verticale.
     * 
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return width;
    }
    
    
    /**
     * Accesseur de la hauteur de la barre verticale.
     * 
     * @return la hauteur
     */
    @Override
    public double getHeight() {
        return height;
    }
    
    
    /**
     * Fonction appelée à chaque frame qui met à jour la position de la barre
     * verticale.
     * 
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        x += dt * vx;

        if (x + width / 2 > screenwidth) {
            vx = -vx;
            x = screenwidth - width / 2;
        } else if (x - width / 2 < 0) {
            vx = -vx;
            x = width / 2;
        }
    }

    
    /**
     * Indique si le player est entré en collision avec une barre verticale alors
     * qu'il n'était pas de la bonne couleur.
     * 
     * @param player Le player
     * @return true s'il y a eu collision, false sinon
     */
    @Override
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getWestBorder()  < this.getX() + this.getWidth() / 2
                && player.getEastBorder()  > this.getX() - this.getWidth() / 2
                && player.getSouthBorder() < this.getY() + this.getHeight() / 2
                && player.getNorthBorder() > this.getY() - this.getHeight() / 2;
    }

}
