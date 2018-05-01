package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import org.legtux.g316k.colorswitch.model.level.Level;

/**
 * Classe abstraite
 *
 * Définit quelques fonctions statiques utiles lors du rendu
 */
public abstract class Renderer {

    public abstract void draw(Level level, Canvas canvas, Context context);

    /**
     * Converti un numéro de couleur 0 à 3 en une couleur de JavaFX
     *
     * @param color le numéro de couleur
     * @return la couleur associée
     */
    public static int convertColor(int color) {
        switch (color) {
            case 0:
                return Color.rgb(240, 128, 128);
            case 1:
                return Color.rgb(0, 255, 127);
            case 2:
                return Color.rgb(30, 144, 255);
            case 3:
                return Color.rgb(255, 165, 0);
            case 4:
                return Color.rgb(230, 230, 230);  // couleur effet shield
            case 5:
                return Color.rgb(240, 128, 224);  // couleur effet gravity
            case 6:
                return Color.rgb(240, 219, 128);  // couleur effet jetpack
            case 7:
                return Color.rgb(127, 127, 127);  // couleur oscillante pour les effets

        }

        throw new IllegalArgumentException("Couleur inconnue");
    }

    /**
     * Calcule la position sur l'écran d'une entité à pratir de sa position Y
     * dans le niveau.
     *
     * @param level Niveau actuel
     * @param levelY Coordonnée Y dans le niveau
     * @return La coordonnée Y dans le système de coordonnées de la fenêtre
     * JavaFX
     */
    public static double computeScreenY(Level level, double levelY) {

        double y = levelY - level.getScroll();

        return level.getScreenHeight() - y;
    }
}
