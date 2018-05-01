package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.legtux.g316k.colorswitch.model.obstacle.Cruncher;
import org.legtux.g316k.colorswitch.model.level.Level;

/**
 * Classe qui fait le rendu du cruncher.
 */
public class CruncherRenderer extends Renderer {

    private final Cruncher cruncher;
    private final int side;
    private final Paint paint;

    /**
     * Constructeur de ce renderer.
     * 
     * @param cruncher l'instance du cruncher à afficher.
     * @param side détermine les côtés dessinés : -1 -> gauche seulement,
     * 1 -> droit seulement, 0 -> les deux côté (full cruncher)
     */
    public CruncherRenderer(Cruncher cruncher, int side) {
        this.cruncher = cruncher;
        this.side = side;
        this.paint = new Paint();
    }

    
    /**
     * Affiche les rectangles représentant le cruncher.
     * 
     * @param level le niveau du jeu (permet de calculer la position en y)
     * @param canvas le context dans lequel on doit afficher
     */
    @Override
    public void draw(Level level, Canvas canvas, Context context) {

        double canvasY = Renderer.computeScreenY(level, cruncher.getY());

        paint.setColor(Renderer.convertColor(cruncher.getColor()));

        // moitié droite
        if (side < 1) {
            canvas.drawRect(
                    (float) (cruncher.getX() - cruncher.getWidth() / 2),
                    (float) (canvasY - cruncher.getHeight() / 2),
                    (float) (cruncher.getX() + cruncher.getWidth() / 2),
                    (float) (canvasY + cruncher.getHeight() / 2),
                    paint);
        }

        // moitié gauche
        if (side > -1) {
            canvas.drawRect(
                    (float) (cruncher.getX2() - cruncher.getWidth() / 2),
                    (float) (canvasY - cruncher.getHeight() / 2),
                    (float) (cruncher.getX2() + cruncher.getWidth() / 2),
                    (float) (canvasY + cruncher.getHeight() / 2),
                    paint);
        }
    }

}
