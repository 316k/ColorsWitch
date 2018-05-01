package org.legtux.g316k.colorswitch.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import org.legtux.g316k.colorswitch.Controller;
import org.legtux.g316k.colorswitch.model.Entity;
import org.legtux.g316k.colorswitch.model.Game;

public class GameAnimationView extends AnimationView {

    public long last_time;
    private Controller controller;
    private GestureDetector gestureDetector;

    public GameAnimationView(Context context) {
        super(context);
        last_time = System.currentTimeMillis();
        controller = new Controller();

        gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                controller.spaceTyped();
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                controller.spaceTyped();
                controller.spaceTyped();
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (velocityY < -4000)
                    controller.jTyped();
                else
                    controller.spaceTyped();

                return true;
            }
        });
    }

    public void draw(Canvas canvas) {

        long time = System.currentTimeMillis();
        long delta_time = time - last_time;

        controller.tick(delta_time * 1.0e-3);

        // Repaint le canvas
        canvas.drawColor(Color.BLACK);

        canvas.save();

        float h = canvas.getHeight(), w = canvas.getWidth();
        canvas.scale(w / Game.WIDTH, h / Game.HEIGHT);

        for (Entity e : controller.getEntities()) {
            if (e.getRepresentation() != null)
                e.getRepresentation().draw(controller.getCurrentLevel(), canvas, getContext());
        }

        canvas.restore();

        last_time = time;
    }

    public void onTouch(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
    }
}