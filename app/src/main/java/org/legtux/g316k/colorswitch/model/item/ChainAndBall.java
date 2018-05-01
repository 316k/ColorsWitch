
package org.legtux.g316k.colorswitch.model.item;

import org.legtux.g316k.colorswitch.model.Game;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.ImageRenderer;

/**
 * Item : Chaine et boulet.
 * 
 * Ralentit la progression de la sorcière en ajoutant un poids.
 */
public class ChainAndBall extends Item {
    
    private boolean used;
    private double radius;

    /**
     * Constructeur d'un objet ChainAndBall
     * 
     * @param x coordonnée en x du centre de l'item
     * @param y coordonnée en y du centre de l,item
     */
    public ChainAndBall(double x, double y) {
        super(x, y);
        
        this.used = false;
        this.radius = 32;
        
        this.renderer = new ImageRenderer("chain-and-ball", this);
    }

    
    /**
     * Rien à faire d'un tick à l'autre.
     * 
     * @param dt interval de temps
     */
    @Override
    public void tick(double dt) {
        // Rien à faire
    }

    
    /**
     * Largeur de l'item.
     * 
     * @return largeur en pixel
     */
    @Override
    public double getWidth() {
        return 2 * radius;
    }

    
    /**
     * Hauteur de l'item.
     * 
     * @return hauteur en pixel
     */
    @Override
    public double getHeight() {
        return 2 * radius;
    }

    
    /**
     * Apellé lorsque le joueur entre en collision avec l'item.
     * Force le joueur à augmenter sa gravité pour un temps et rends
     * l'item désuet (un seul usage).
     * 
     * @param player le joueur
     * @param game le jeu
     */
    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("used-chain-and-ball", this);
        player.increaseGravity();
    }

    
    /**
     * Détermine s'il y a intersection entre le joueur et l'item.
     * 
     * @param player le joueur
     * @return true s'il y a intersection
     */
    @Override
    public boolean intersects(Player player) {
        double dx = x - player.getX();
        double dy = y - player.getY();
        double d2 = dx * dx + dy * dy;
        
        return !used && 
                d2 < (radius + player.getRadius()) * (radius + player.getRadius());
    }
   
}
