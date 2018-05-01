package org.legtux.g316k.colorswitch.view;

import android.gesture.Gesture;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GameAnimationView animationView;
    private GestureDetectorCompat detector;

    public static final String DEBUG_TAG = "TWADO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        animationView = new GameAnimationView(this);

        setContentView(animationView);

        // Garde l'écran allumé même s'il n'y a pas d'activité
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        animationView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                animationView.onTouch(motionEvent);

                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Évite de donner un très long delta_time si on quitte l'app et on revient plus tard
        animationView.last_time = System.currentTimeMillis();
    }
}
