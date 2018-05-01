package org.legtux.g316k.colorswitch.model.item;

import org.legtux.g316k.colorswitch.model.Game;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.ImageRenderer;

/**
 * Item : Le JetPack permet de sauter au-dessus des obstacles lorsqu'il est 
 * activé par le joueur.
 *
 */
public class JetPack extends Item {

    private boolean used;
    private double height;
    private double width;
    
    /**
     * Constructeur de la classe JetPack.
     * 
     * @param x La coordonnée en x du JetPack.
     * @param y La coordonnée en y du JetPack.
     */
    public JetPack(double x, double y) {
        super(x, y);
        
        this.height = 64;
        this.width = 64;

        this.renderer = new ImageRenderer("jetpack", this);
    }
    
    
    /**
     * Fonction appelée à chaque frame pour mettre à jour les attributs de
     * l'entité.
     *
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        // Rien à faire
    }

    
    /**
     * Accesseur de la largeur du JetPack.
     * 
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return width;
    }

    
    /**
     * Accesseur de la hauteur du JetPack.
     * 
     * @return la hauteur
     */
    @Override
    public double getHeight() {
        return height;
    }

    
    /**
     * Fonction gère l'acquisition du JetPack par le player.
     * 
     * @param player Le player
     * @param game La partie
     */
    @Override
    public void handleCollision(Player player, Game game) {
        if (!used) {
            player.jetPackUp();
        }

        used = true;
        this.renderer = new ImageRenderer("used-jetpack", this);
    }

    
    /**
     * Retourne un booléen indiquant si le player est entré en collision avec 
     * le JetPack pour la première fois.
     * 
     * @param player Le player
     * @return true s'il y a eu collision pour la première fois avec le JetPack,
     * false sinon.
     */
    @Override
    public boolean intersects(Player player) {
        return !used
                && player.getWestBorder()  < this.getX() + this.getWidth() / 2
                && player.getEastBorder()  > this.getX() - this.getWidth() / 2
                && player.getSouthBorder() < this.getY() + this.getHeight() / 2
                && player.getNorthBorder() > this.getY() - this.getHeight() / 2;
    }

}
