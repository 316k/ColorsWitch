package org.legtux.g316k.colorswitch.model;


public interface RoundShape {

    /**
     * Accesseur du rayon du player.
     *
     * @return le rayon
     */
    public double getRadius();

    /**
     * Accesseur de la couleur d'une balle.
     *
     * @return la couleur
     */
    public int getColor();

    public double getX();
    public double getY();
}
