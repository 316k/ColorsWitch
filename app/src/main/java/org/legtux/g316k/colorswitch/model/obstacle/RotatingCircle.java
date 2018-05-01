package org.legtux.g316k.colorswitch.model.obstacle;

import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.model.RoundShape;
import org.legtux.g316k.colorswitch.view.renderer.BallRenderer;

/**
 * Obstacle : Cercle de couleur invariable, mais qui qui grossit et rétrécit 
 * avec le temps.
 */
public class RotatingCircle extends Obstacle implements RoundShape {
    private final double radius;
    private final double angle;
    private final double centerX, centerY;
    private double timeSinceColorChange;
    
    /**
     * Constructeur de la classe RotatingCircle.
     * 
     * @param centerX La coordonnée en en X du centre du cercle
     * @param centerY La coordonnée en en Y du centre du cercle
     * @param circleRadius Le rayon du cercle
     * @param rotationRadius Le rayon de rotation
     * @param angle L'angle de rotation
     */
    public RotatingCircle(double centerX, double centerY,  double circleRadius, double rotationRadius, double angle) {
        super(centerX, centerY + rotationRadius);
        
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = circleRadius;
        this.angle = Math.toRadians(angle);
        
        this.timeSinceColorChange = 0;
        this.renderer = new BallRenderer(this);

        this.color = (int) (Math.random() * 4);
    }

    
    /**
     * Accesseur de la largeur du cercle rotatif.
     * 
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return 2 * radius;
    }
    
    
    /**
     * Accesseur de la hauteur du cercle rotatif.
     * 
     * @return la hauteur
     */
    @Override
    public double getHeight() {
        return 2 * radius;
    }

    
    /**
     * Accesseur du rayon du cercle rotatif.
     * 
     * @return le rayon
     */
    public double getRadius() {
        return radius;
    }
    
    
    /**
     * Fonction appelée à chaque frame qui met à jour les coordonnées du cercle.
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
        
        double dx = x - centerX;
        double dy = y - centerY;
        x = centerX + dx * Math.cos(angle) - dy * Math.sin(angle);
        y = centerY + dx * Math.sin(angle) + dy * Math.cos(angle);
    }

    
    /**
     * Indique si le player est entré en collision avec le cercle rotatif alors
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
