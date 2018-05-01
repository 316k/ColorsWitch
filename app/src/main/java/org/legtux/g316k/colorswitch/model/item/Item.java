package org.legtux.g316k.colorswitch.model.item;

import org.legtux.g316k.colorswitch.model.LevelElement;

/**
 * Classe abstraite représentant un item (powerup/champignon/...)
 */
public abstract class Item extends LevelElement {

    public Item(double x, double y) {
        super(x, y);
    }
}
