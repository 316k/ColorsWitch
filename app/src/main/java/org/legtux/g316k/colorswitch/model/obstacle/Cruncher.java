package org.legtux.g316k.colorswitch.model.obstacle;


import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.CruncherRenderer;

/**
 * Obstacle : Deux barres horizontales attachées aux côtées de l'écran
 * qui se raprochent jusqu'à se toucher puis en s'éloignent de manière cyclique.
 * On peut également avoir un demi Cruncher droite ou gauche, ce dernier
 * n'est alors constitué que d'une seule barre.
 */
public class Cruncher extends Obstacle {
    
    private final double screenwidth;
    private final double minWidth;
    private final double maxWidth;
    private final double height;
    private double vx;
    private double x2;
    
    private double timeSinceColorChange;
    private double currentWidth;

    /**
     * Constructeur d'un Cruncher
     * 
     * @param y la coordonnée en y du cruncher
     * @param largeurMin la largeur minimale d'une barre
     * @param largeurEcran la largeur de l'écran
     * @param hauteur la hauteur du cruncher
     * @param vitesse la vitesse d'ouverture/fermeture du cruncher
     * @param side détermine les côtés dessinés : -1 -> gauche seulement,
     * 1 -> droite seulement, 0 -> les deux côté (full cruncher)
     */
    public Cruncher(double y, double largeurMin, double largeurEcran, double hauteur, double vitesse, int side) {
        super(largeurMin/4, y);
        
        this.screenwidth = largeurEcran;
        this.minWidth = largeurMin;
        this.maxWidth = largeurEcran/2;
        this.height = hauteur;
        this.vx = vitesse;
        this.x2 = largeurEcran - x;
        
        this.timeSinceColorChange = 0;
        this.currentWidth = this.minWidth;

        this.renderer = new CruncherRenderer(this, side);

        this.color = (int) (Math.random() * 4);
    }

    
    /**
     * Retourne la coordonnée en x du centre du cruncher gauche.
     * 
     * @return la valeur en pixel
     */
    public double getX2() {
        return x2;
    }
    
    
    /**
     * Retourne la largeur actuel d'un demi cruncher.
     * 
     * @return la largeur en pixel
     */
    @Override
    public double getWidth() {
        return currentWidth;
    }

    
    /**
     * Retourne la hauteur du cruncher.
     * 
     * @return la hauteur en pixel
     */
    @Override
    public double getHeight() {
        return height;
    }

    
    /**
     * Détermine la dimension des ailes gauche et droite
     * du cruncher avec le temps.
     * 
     * @param dt variation de temps
     */
    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;

        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }

        currentWidth += dt * vx;
        if (currentWidth > maxWidth) {
            currentWidth = maxWidth;
            vx = -vx;
        } else if (currentWidth < minWidth) {
            currentWidth = minWidth;
            vx = -vx;
        }
        x = currentWidth / 2;
        x2 = screenwidth - x;
    }

    
    /**
     * Comme un cruncher est symétrique, il suffit de déterminer si l'un
     * de ses côté intersecte (même lorsque seulement l'autre côté est affiché).
     * 
     * @param player le joeur
     * @return true s'il y a intersection.
     */
    @Override
    public boolean intersects(Player player) {
        /**
         * Il est suffisant de vérifier l'intersection avec la moitiée droite
         * du cruncher.
         */ 
        return this.color != player.getColor()
                && player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }

}
