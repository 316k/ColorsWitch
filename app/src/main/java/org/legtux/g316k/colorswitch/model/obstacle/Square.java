package org.legtux.g316k.colorswitch.model.obstacle;


import org.legtux.g316k.colorswitch.model.Obstacle;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.RectangleRenderer;

/**
 * Obstacle simple : un carré qui change de couleur à toutes les 2 secondes.
 */
public class Square extends Obstacle {

    private double width;
    private double timeSinceColorChange = 0;

    /**
     * Constructeur d'un objet Square.
     *
     * @param x La coordonnée en x
     * @param y La coordonnée en y
     * @param longueur La longueur du carré
     */
    public Square(double x, double y, double longueur) {
        super(x, y);

        this.width = longueur;
        this.renderer = new RectangleRenderer(this);

        this.color = (int) (Math.random() * 4);
    }


    /**
     * Accesseur de la largeur du carré.
     *
     * @return la largeur
     */
    @Override
    public double getWidth() {
        return width;
    }


    /**
     * Accesseur de la hauteur du carré.
     *
     * @return la hauteur
     */
    @Override
    public double getHeight() {
        return width;
    }


    /**
     * Fonction appelée à chaque frame pour mettre à jour la couleur du carré.
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
    }


    /**
     * Retourne un booléen indiquant si le player est entré en collision avec
     * un carré lorsqu'il n'avait pas la bonne couleur.
     *
     * @param player Le player
     * @return true s'il y a eu collision et si la couleur du player était différente
     * de celle du carré, false sinon.
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
