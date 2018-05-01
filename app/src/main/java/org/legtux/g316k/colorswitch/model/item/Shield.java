package org.legtux.g316k.colorswitch.model.item;

import org.legtux.g316k.colorswitch.model.Game;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.ImageRenderer;

/**
 * Item : Shield 
 * 
 * Rend le player invincible pendant 3 secondes.
 */
public class Shield extends Item {

    private boolean used;
    private double radius;

    /**
     * Constructeur de la classe Shield.
     * 
     * @param x La coordonnée en x du shield
     * @param y La coordonnée en y du shield
     */
    public Shield(double x, double y) {
        super(x, y);
        this.used = false;
        this.radius = 32;
        
        this.renderer = new ImageRenderer("shield", this);
    }

    /**
     * Fonction appelée à chaque frame pour mettre à jour les attributs de
     * l'entité (ne fait rien dans le cas du shield).
     *
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        // Rien faire
    }

    
    /**
     * Accesseur de la largeur du shield.
     * 
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return 2* radius;
    }

    
    /**
     * Accesseur de la hauteur du shield.
     * 
     * @return la hauteur
     */
    @Override
    public double getHeight() {
        return 2* radius;
    }

    
    /**
     * Fonction qui gère l'acquisition du shield par le player.
     * 
     * @param player Le player
     * @param game La partie
     */
    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("used-shield", this);
        
        player.shieldUp();
    }

    
    /**
     * Retourne un booléen indiquant si le player est entré en collision avec 
     * le shield alors que celui-ci n'a pas encore été utilisé.
     * 
     * @param player Le player
     * @return true s'il y a eu collision alors que le shield n'a pas encore été
     * utilisé, false sinon.
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
