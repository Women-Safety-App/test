package com.example.bsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Ratting extends AppCompatActivity {
    RatingBar ratingBar;
    Button btsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ratting);

        ratingBar= findViewById(R.id.rating_bar);
        btsubmit= findViewById(R.id.bt_submit);

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),s+"Star", Toast.LENGTH_SHORT).show();
            }
        });
    }
}