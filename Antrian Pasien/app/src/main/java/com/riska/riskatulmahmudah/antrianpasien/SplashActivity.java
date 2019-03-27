package com.riska.riskatulmahmudah.antrianpasien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar pgloading;
    private TextView tvloading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pgloading = (ProgressBar)findViewById(R.id.pbloading);
        tvloading=(TextView)findViewById(R.id.tvloading);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        pgloading.startAnimation(myanim);
        tvloading.startAnimation(myanim);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
