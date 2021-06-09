package com.example.bsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class myinfo extends AppCompatActivity {
    private ImageButton imageButton;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_myinfo);
        textView1= findViewById(R.id.entername);
        textView2=findViewById(R.id.enterphone);
        textView3=findViewById(R.id.fullmane);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MySigninPreference", Context.MODE_PRIVATE);
        String namestr = sp.getString("namestr", "");
        String phonestr = sp.getString("phonestr", "");
        textView1.setText(namestr);
        textView2.setText(phonestr);
        textView3.setText(namestr);

        imageButton= findViewById(R.id.back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
                finish();
            }
        });

    }
}