package org.legtux.g316k.colorswitch.model.item;

import org.legtux.g316k.colorswitch.model.Game;
import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.view.renderer.ImageRenderer;

/**
 * Item : Potion magique.
 * 
 * Fait changer la sorcière de couleur
 */
public class Potion extends Item {

    private boolean used = false;

    public Potion(double x, double y) {
        super(x, y);

        this.renderer = new ImageRenderer("potion", this);
    }

    @Override
    public void tick(double dt) {
        // Rien à faire
    }

    @Override
    public double getWidth() {
        return 48;
    }

    @Override
    public double getHeight() {
        return 48;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("empty-potion", this);
        player.randomizeColor();
    }

    @Override
    public boolean intersects(Player player) {
        return !used
                && player.getX() < this.getX() + this.getWidth() / 2
                && player.getX() > this.getX() - this.getWidth() / 2
                && player.getY() < this.getY() + this.getHeight() / 2
                && player.getY() > this.getY() - this.getHeight() / 2;
    }
}
