package com.example.bsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mainpage extends AppCompatActivity {
    private Button button12;
    private TextView tv;
    private EditText et1;
    private EditText et2;
    SharedPreferences ecsp;
    String ec1str;
    String ec2str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mainpage);
        tv=findViewById(R.id.tv);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        ecsp = getSharedPreferences("EmergencyContactPreference", Context.MODE_PRIVATE);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MySigninPreference", Context.MODE_PRIVATE);
        String namestr = sp.getString("namestr", "");
        tv.setText(namestr);


        button12= (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ec1str =et1.getText().toString().trim();
                ec2str=et2.getText().toString().trim();

                SharedPreferences.Editor editor = ecsp.edit();
                editor.putString("et1",ec1str);
                editor.putString("et2",ec2str);
                editor.commit();

                if (!ec1str.isEmpty() & !ec2str.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), mainsos.class);


                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(mainpage.this, "Enter Emergency Numbers",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
            });

    }
}