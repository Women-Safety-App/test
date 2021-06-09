package com.example.bsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
   // Thread timer;

        private static int SPLASH_TIME_OUT = 5000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().hide();
            setContentView(R.layout.activity_main);
            imageView = (ImageView) findViewById(R.id.imageView);

           /* timer = new Thread(){
                @Override
                public void run() {
                    try {
                        synchronized (this){
                            wait(5000);
                        }
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity (intent);
                        finish();
                    }
                }
            };
            timer.start(); */

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   // Animation startanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                  //  imageView.startAnimation(startanimation);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity (intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }


