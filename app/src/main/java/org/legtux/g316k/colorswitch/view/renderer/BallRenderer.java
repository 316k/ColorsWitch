package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.legtux.g316k.colorswitch.model.level.Level;
import org.legtux.g316k.colorswitch.model.RoundShape;

/**
 * Fait le rendu d'un Player sur l'écran en dessinant un cercle coloré
 */
public class BallRenderer extends Renderer {

    protected RoundShape ball;
    protected Paint paint;

    public BallRenderer(RoundShape ball) {
        this.ball = ball;
        this.paint = new Paint();
    }

    @Override
    public void draw(Level level, Canvas canvas, Context context) {
        float canvasY = (float) Renderer.computeScreenY(level, ball.getY());

        paint.setColor(Renderer.convertColor(ball.getColor()));

        canvas.drawCircle((float) ball.getX(),
                canvasY,
                (float) ball.getRadius(),
                paint);
    }
}
