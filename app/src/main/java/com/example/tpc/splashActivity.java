package com.example.tpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        EasySplashScreen config = new EasySplashScreen(splashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundColor(Color.parseColor("#8B0E0E"))
                .withHeaderText("TRAINING AND PLACEMENT CELL, RAIT")
                .withFooterText("@RAIT_TPC")
                .withBeforeLogoText("TPC DATA CENTRE \n")
                .withAfterLogoText("\n One Stop For All Your Data")
                .withLogo(R.drawable.tpc1);

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);*/
    }
}
