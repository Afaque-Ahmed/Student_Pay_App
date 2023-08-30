package com.example.studentpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000; // Splash screen display time (milliseconds)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the ImageViews for your logos
        ImageView logo1 = findViewById(R.id.logo1);
        ImageView logo2 = findViewById(R.id.logo2);
        ImageView logo3 = findViewById(R.id.logo3);

        // Initialize the TextViews for "Student Pay"
        TextView text1 = findViewById(R.id.splash_text1);
        TextView text2 = findViewById(R.id.splash_text2);

        // Load the animation XML files for the logos
        Animation slideInFromLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_left);
        Animation slideInFromRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_right);
        Animation cap_animation = AnimationUtils.loadAnimation(this, R.anim.splash_cap_animation);
        Animation splash_text1 = AnimationUtils.loadAnimation(this, R.anim.splash_text1_animation);
        Animation splash_text2 = AnimationUtils.loadAnimation(this, R.anim.splash_text2_animation);

        // Apply animations to the logos
        logo1.startAnimation(slideInFromLeft);
        logo2.startAnimation(slideInFromRight);
        logo3.startAnimation(cap_animation);

        text1.startAnimation(splash_text1);
        text2.startAnimation(splash_text2);

        // Use a Handler to navigate to the main activity after SPLASH_TIME_OUT milliseconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
