package org.legtux.g316k.colorswitch.model;

import org.legtux.g316k.colorswitch.view.renderer.BallRenderer;

/**
 * Classe créant une explosion de balles lors de la mort du player.
 */
public class BallExplosion extends Entity implements RoundShape {

    private double radius;
    private int color;
    private double vy, vx;
    private double ay, ax;
    private double minX, screenWidth, minY, screenHeight;

    /**
     * Constructeur d'un objet BallExplosion.
     * 
     * @param x La coordonnée en x
     * @param y La coordonnée en y
     * @param rayonBalle Le rayon de la balle
     * @param rayonPlayer Le rayon du player
     * @param color La couleur de la balle
     * @param minX La cordonnée minimale en x
     * @param screenWidth La largeur de l'écran
     * @param minY La coordonnée minimale en y
     * @param screenHeight La hauteur de l'écran
     */
    public BallExplosion(double x, double y, double rayonBalle, double rayonPlayer,
                    int color, double minX, double screenWidth, double minY,
                    double screenHeight) {
        super(Math.random() * ((x + rayonPlayer) - (x - rayonPlayer)) + (x - rayonPlayer), 
                    Math.random() * ((y + rayonPlayer) - (y - rayonPlayer)) + (y - rayonPlayer));
        
        this.color = color;
        this.radius = rayonBalle;
        this.ay = -200;
        this.ax = 0;
        this.vx = (int)(Math.random() * (300 -(-300)) -300);
        this.vy = (int)(Math.random() * (250 -(-250)) -250);
        this.minX = minX;
        this.screenWidth = screenWidth;
        this.minY = minY;
        this.screenHeight = screenHeight;

        this.renderer = new BallRenderer(this);
    }
    
    
    /**
     * Accesseur de la largeur d'une balle.
     * 
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return this.getRadius() * 2;
    }

    
    /**
     * Accesseur de la hauteur d'une balle.
     * 
     * @return la largeur
     */
    @Override
    public double getHeight() {
        return this.getRadius() * 2;
    }
    
    
    /**
     * Accesseur du rayon d'une balle.
     * 
     * @return le rayon
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public int getColor() {
        return color;
    }

    /**
     * Fonction appelée à chaque frame pour mettre à jour la position d'une balle.
     *
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        // Mise à jour de la position
        vy += dt * ay;
        y += dt * vy;
        
        vx += dt * ax;
        x += dt * vx;
        
        
        // Empêche une balle de sortir de l'écran et la fait rebondir
         
        if (y - radius < minY) {
            y = minY + radius;
            vy = -0.2 * vy;
            
        } else if (y + radius > minY + screenHeight) {
            y = minY + screenHeight - radius;
            vy = -0.6 * vy;
            
        } else if (x - radius < minX) {
            x = minX + radius;
            vx = -0.6 * vx;
            
        } else if (x + radius > screenWidth) {
            x = screenWidth - radius;
            vx = -0.6 * vx;
        }
    }
}
