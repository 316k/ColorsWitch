
package org.legtux.g316k.colorswitch.model.obstacle;

import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.model.RoundShape;
import org.legtux.g316k.colorswitch.view.renderer.BallRenderer;

/**
 * Obstacle : Un cercle qui varie en taille et couleur avec le temps.
 */
public class GrowingCircle extends Obstacle implements RoundShape {

    private final double minRadius, maxRadius;
    private double radius;
    private double growingVelocity;
    private double timeSinceColorChange = 0;
    
    
    /**
     * Constructeur de la classe GrowingCircle.
     * 
     * @param x La coordonnée en x du cercle
     * @param y La coordonnée en y du cercle
     * @param minRadius Le rayon minimal du cercle
     * @param maxRadius Le rayon maximal du cercle
     * @param vitesse La vitesse à laquelle la taille du cercle varie
     */
    public GrowingCircle(double x, double y, double minRadius, double maxRadius, double vitesse) {
        super(x, y);
        
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radius = minRadius;
        this.growingVelocity = vitesse;

        this.renderer = new BallRenderer(this);

        this.color = (int) (Math.random() * 4);
    }

    
    /**
     * Accesseur de la largeur du cercle.
     * 
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return 2 * radius;
    }

    
    /**
     * Accesseur de la hauteur du cercle.
     * 
     * @return la hauteur
     */
    @Override
    public double getHeight() {
        return 2 * radius;
    }

    
    /**
     * Accesseur du rayon du cercle.
     * 
     * @return le rayon
     */
    public double getRadius() {
        return radius;
    }
    
    
    /**
     * Fonction appelée à chaque frame qui met à jour la taille du cercle.
     * 
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;

        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
        
        radius += dt * growingVelocity;
        
        if (radius >= maxRadius) {
            growingVelocity = -growingVelocity;
            radius = maxRadius;
        } else if (radius <= minRadius) {
            growingVelocity = -growingVelocity;
            radius = minRadius;
        }
    }

    
    /**
     * Indique si le player est entré en collision avec un cercle alors
     * qu'il n'était pas de la bonne couleur.
     * 
     * @param player Le player
     * @return true s'il y a eu collision, false sinon
     */
    @Override
    public boolean intersects(Player player) {
        double dx = x - player.getX();
        double dy = y - player.getY();
        double d2 = dx * dx + dy * dy;
        
        return color != player.getColor()
                && d2 < (radius + player.getRadius()) * (radius + player.getRadius());
    }
    
}
