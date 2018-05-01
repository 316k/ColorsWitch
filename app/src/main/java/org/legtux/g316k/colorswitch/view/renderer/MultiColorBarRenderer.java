package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.legtux.g316k.colorswitch.model.level.Level;
import org.legtux.g316k.colorswitch.model.obstacle.MultiColorBar;


/**
 * Classe permetant d'afficher une instance de MultiColorBar
 */
public class MultiColorBarRenderer extends Renderer {

    private MultiColorBar multicolorBar;
    private Paint paint;

    /**
     * Instancie un MultiColorBarRenderer pour l'instance MultiColorBar
     * passée en paramètre.
     * 
     * @param multicolorBar l'intance pour laquelle le rendue doit être effectué
     */
    public MultiColorBarRenderer(MultiColorBar multicolorBar) {
        this.multicolorBar = multicolorBar;
        this.paint = new Paint();
    }

    
    /**
     * Affiche toutes les sections d'une MultiColorBar
     * 
     * @param level le niveau du jeu (permet de calculer la postion en y)
     * @param canvas le context dans lequel l'affichage sera effectué
     */
    @Override
    public void draw(Level level, Canvas canvas, Context context) {

        double[] x = multicolorBar.getAllX();
        int[] color = multicolorBar.getAllColor();

        double canvasY = Renderer.computeScreenY(level, multicolorBar.getY());
        double halfWidth = multicolorBar.getWidth() / 2;
        double correctedHalfHeight = canvasY - multicolorBar.getHeight() / 2;
        double totalWidth = x.length * multicolorBar.getWidth();

        for (int i = 0; i < x.length; i++) {
            paint.setColor(Renderer.convertColor(color[i]));

            if (x[i] < halfWidth) {
                double diff = halfWidth - x[i];
                canvas.drawRect(
                        (float) (totalWidth - diff),
                        (float) (correctedHalfHeight),
                        (float) totalWidth,
                        (float) (correctedHalfHeight + multicolorBar.getHeight()),
                        paint);

                double wLarge = multicolorBar.getWidth() - diff;
                canvas.drawRect(
                        0,
                        (float) correctedHalfHeight,
                        (float) (multicolorBar.getWidth() - diff),
                        (float) (correctedHalfHeight + multicolorBar.getHeight()),
                        paint);

            } else if (x[i] > totalWidth - halfWidth) {
                double diff = x[i] - totalWidth + halfWidth;
                canvas.drawRect(
                        0,
                        (float) correctedHalfHeight,
                        (float) diff,
                        (float) (correctedHalfHeight + multicolorBar.getHeight()),
                        paint);

                double wLarge = multicolorBar.getWidth() - diff;
                canvas.drawRect(
                        (float) (totalWidth - wLarge),
                        (float) correctedHalfHeight,
                        (float) totalWidth,
                        (float) (correctedHalfHeight + multicolorBar.getHeight()),
                        paint);

            } else {
                canvas.drawRect(
                        (float) (x[i] - halfWidth),
                        (float) correctedHalfHeight,
                        (float) (x[i] + halfWidth),
                        (float) (correctedHalfHeight + multicolorBar.getHeight()),
                        paint);
            }
        }

    }

}
