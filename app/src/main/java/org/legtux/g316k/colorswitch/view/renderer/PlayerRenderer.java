package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;

import org.legtux.g316k.colorswitch.model.Player;
import org.legtux.g316k.colorswitch.model.level.Level;

/**
 * Fait le rendu d'un Player sur l'écran en dessinant un cercle coloré
 */
public class PlayerRenderer extends BallRenderer {

    protected Player player;

    public PlayerRenderer(Player player) {
        super(player);
        this.player = player;
    }

    
    @Override
    public void draw(Level level, Canvas canvas, Context context) {

        double canvasY = Renderer.computeScreenY(level, player.getY());

        if (player.hasShield()) {

            paint.setColor(Renderer.convertColor(player.getShieldColor()));

            double auraRadius = player.getRadius() + 5;

            canvas.drawCircle(
                    (float) player.getX(),
                    (float) canvasY,
                    (float) auraRadius,
                    paint);
        }

        if (player.hasGravity()) {

            paint.setColor(Renderer.convertColor(player.getGravityColor()));

            double auraRadius = player.getRadius() + 5;

            canvas.drawCircle(
                    (float) player.getX(),
                    (float) canvasY,
                    (float) auraRadius,
                    paint);
        }
        
        if (player.getJetPackInUse()) {

            paint.setColor(Renderer.convertColor(player.getJetPackColor()));

            double auraRadius = player.getRadius() + 5;

            canvas.drawCircle(
                    (float) player.getX(),
                    (float) canvasY,
                    (float) auraRadius,
                    paint);
        }

        super.draw(level, canvas, context);
    }
}
