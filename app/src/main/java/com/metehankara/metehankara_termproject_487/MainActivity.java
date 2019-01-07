package com.metehankara.metehankara_termproject_487;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView downloading ;
    private static int TIME_OUT = 4000; //Time to launch the another activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        downloading = findViewById(R.id.textView2);

        ObjectAnimator.ofObject(
                downloading, // Object to animating
                "textColor", // Property to animate
                new ArgbEvaluator(), // Interpolation function
                Color.BLUE, // Start color
                Color.RED,
                Color.BLUE,
                Color.RED// End color
        ).setDuration(800) // Duration in milliseconds
                .start();

        //Opening WelcomePageActivity Gesture
        final View myLayout = findViewById(R.id.activity_welcome_page);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, WelcomePageActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }

}
