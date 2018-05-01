package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.legtux.g316k.colorswitch.model.level.Level;
import org.legtux.g316k.colorswitch.model.Obstacle;

/**
 * Fait le rendu d'un rectangle
 */
public class RectangleRenderer extends Renderer {

    private Obstacle carre;
    private Paint paint;

    public RectangleRenderer(Obstacle c) {
        this.carre = c;
        this.paint = new Paint();
    }

    @Override
    public void draw(Level level, Canvas canvas, Context context) {

        double canvasY = Renderer.computeScreenY(level, carre.getY());

        paint.setColor(Renderer.convertColor(carre.getColor()));

        canvas.drawRect(
                (float) (carre.getX() - carre.getWidth() / 2),
                (float) (canvasY - carre.getHeight() / 2),
                (float) (carre.getX() + carre.getWidth() / 2),
                (float) (canvasY + carre.getHeight() / 2),
                paint);
    }
}
