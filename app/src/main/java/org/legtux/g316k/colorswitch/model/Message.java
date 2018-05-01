package org.legtux.g316k.colorswitch.model;

import org.legtux.g316k.colorswitch.model.item.Item;
import org.legtux.g316k.colorswitch.view.renderer.TextRenderer;

/**
 * Objet permettant d'afficher un message dans un niveau.
 */
public class Message extends Item {
    private final double width;
    private final double fontSize;

    /**
     * Instance un message avec son contenu.
     * 
     * @param x coordonnée en x du centre du texte à afficher
     * @param y coordonnée en y du centre du texte à afficher
     * @param text le texte à afficher
     * @param fontSize la taille de la police
     */
    public Message(double x, double y, String text, double fontSize) {
        super(x, y);
        
        this.width = text.length();
        this.fontSize = fontSize;
        this.renderer = new TextRenderer(text, this, fontSize);
    }

    
    /**
     * Détermine l'intersection en l'avatar du joueur et le texte
     * 
     * @param player le joueur
     * @return false (aucune intersection possible)
     */
    @Override
    public boolean intersects(Player player) {
        return false;
    }

    
    /**
     * Il n'y a aucune collision entre le joeur et un message.
     * 
     * @param player le joueur
     * @param game le jeu
     */
    @Override
    public void handleCollision(Player player, Game game) {
        // Rien à faire
    }

    
    /**
     * Largeur du texte.
     * 
     * @return le nombre de caractère
     */
    @Override
    public double getWidth() {
        return width;
    }

    
    /**
     * Hauteur du texte
     * 
     * @return la taille de la police
     */
    @Override
    public double getHeight() {
        return fontSize;
    }

    
    /**
     * Rien à faire d'un tick à l'autre.
     * 
     * @param dt variation de temps
     */
    @Override
    public void tick(double dt) {
        // Rien à faire
    }
    
}
