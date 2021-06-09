package com.example.bsafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.bsafe.R.id.imageButton;

public class mainsos extends AppCompatActivity {
    private ImageButton imageButton;

    @Override
    public void   onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_mainsos);
        imageButton= (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
            }
        });


            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.SOS);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
                switch (menuItem.getItemId()) {

                    case R.id.SOS:
                        return true;
                    case R.id.call:
                        startActivity(new Intent(getApplicationContext(), call.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.message:
                        startActivity(new Intent(getApplicationContext(), message.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.kit:
                        startActivity(new Intent(getApplicationContext(), kit.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.bulb:
                        startActivity(new Intent(getApplicationContext(), bulb.class));
                        overridePendingTransition(0, 0);
                        return true;


                }

                return false;

            }

            });


        }
}

