package com.example.bsafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class login extends AppCompatActivity {
   // private EditText etusername;
  //  private  EditText etpassword;
    private Button btlogin;
private Button btsignup;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        Log.d("check","in login create method");
       // etusername= findViewById(R.id.username);
       // etpassword= findViewById(R.id.passcode);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.username, R.id.Name,R.string.invalid_username);
        awesomeValidation.addValidation(this, R.id.passcode, R.id.password,R.string.invalid_confirm_password);

        btlogin= findViewById(R.id.login);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(), "Welcome to B.Safe", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Username or Password", Toast.LENGTH_SHORT).show();
                }
                Intent intent= new Intent(getApplicationContext(),mainsos.class);
                startActivity(intent);
            }
        });
        btsignup= findViewById(R.id.signup);
        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(),signin.class);
                startActivity(intent);

            }
        });
    }
}