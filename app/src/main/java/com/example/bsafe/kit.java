package com.example.bsafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class kit extends AppCompatActivity {
private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_kit);
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.kit);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.SOS:
                        startActivity(new Intent(getApplicationContext(),mainsos.class));
                        overridePendingTransition(0,0);
                        return true;
//return ;
                    case R.id.call:
                        startActivity(new Intent(getApplicationContext(),call.class));
                        overridePendingTransition(0,0);
                        return true;
//return ;
                    case R.id.message:
                        startActivity(new Intent(getApplicationContext(),message.class));
                        overridePendingTransition(0,0);
                        return true;
//return ;
                    case R.id.kit:
                        return true;
//return ;
                    case R.id.bulb:
                        startActivity(new Intent(getApplicationContext(),bulb.class));
                        overridePendingTransition(0,0);
                        return true;
//return ;

                }
                return false ;



            }
        });
        imageButton= (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
            }
        });
    }
}