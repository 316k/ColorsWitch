package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.legtux.g316k.colorswitch.R;
import org.legtux.g316k.colorswitch.model.Entity;
import org.legtux.g316k.colorswitch.model.level.Level;

/**
 * Fait le rendu d'une Entity sur l'écran en affichant une image
 */

public class ImageRenderer extends Renderer {

    private Entity entity;
    private Paint paint;

    public ImageRenderer(String name, Entity e) {
        this.entity = e;
        this.paint = new Paint();
    }

    @Override
    public void draw(Level level, Canvas canvas, Context context) {

        float x = (float) entity.getX();
        float y = (float) Renderer.computeScreenY(level, entity.getY());

        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.shield);

        canvas.save();

        canvas.translate(
                (float) (x - entity.getWidth()/2),
                (float) (y - entity.getHeight()/2));

        canvas.scale((float) (entity.getWidth() / b.getWidth()), (float) (entity.getHeight() / b.getHeight()));

        canvas.drawBitmap(
                b,
                (float) -1,
                (float) -1,
                paint);

        canvas.restore();
    }
}