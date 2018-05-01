package org.legtux.g316k.colorswitch.view.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import org.legtux.g316k.colorswitch.model.Entity;
import org.legtux.g316k.colorswitch.model.level.Level;

/**
 * Classe responsable d'afficher du texte sur le canvas.
 */
public class TextRenderer extends Renderer {

    private final String text;
    private final Entity entity;
    private final double fontSize;
    private final Paint paint;

    /**
     * Initialise un TextRenderer
     *
     * @param text     le texte à afficher
     * @param entity   l'entité associée au renderer
     * @param fontSize taille de la fonte
     */
    public TextRenderer(String text, Entity entity, double fontSize) {
        this.text = text;
        this.entity = entity;
        this.fontSize = fontSize;
        this.paint = new Paint();

        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize((float) fontSize);
    }

    /**
     * Affiche du texte sur le canvas en le centrant par rapport
     * aux coordonnées de l'entité
     *
     * @param level  (non utilisé) niveau du jeu
     * @param canvas le context utilisé pour afficher le texte
     */
    @Override
    public void draw(Level level, Canvas canvas, Context context) {
        int from = 0;
        int i = 0;
        while (from < text.length()) {
            int to = text.indexOf('\n', from);
            String line;

            if (to == -1) {
                line = text.substring(from);
                from = text.length();
            } else {
                line = text.substring(from, to);
                from = to + 1;
            }

            canvas.drawText(
                    line,
                    (float) entity.getX(),
                    (float) (entity.getY() + i * fontSize),
                    paint);
            i++;
        }
    }
}
