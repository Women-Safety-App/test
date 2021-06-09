package com.example.bsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class signin extends AppCompatActivity {
    private Button button11;
    private EditText etname, etphone, etpassword, etconfirmpassword;
    AwesomeValidation awesomeValidation;
    SharedPreferences sp;
    String namestr;
   String phonestr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);
        etname=findViewById(R.id.Name);
        etphone=findViewById(R.id.Phone);
        etpassword= findViewById(R.id.password);
        etconfirmpassword=findViewById(R.id.confirm_password);
        sp = getSharedPreferences("MySigninPreference", Context.MODE_PRIVATE);

        button11= (Button) findViewById(R.id.button11);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.password, ".{8,}",R.string.invalid_password);
        awesomeValidation.addValidation(this, R.id.confirm_password, R.id.password,R.string.invalid_confirm_password);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               namestr =etname.getText().toString().trim();
               phonestr =etphone.getText().toString().trim();

               SharedPreferences.Editor editor = sp.edit();
               editor.putString("etname",namestr);
               editor.putString("etphone",phonestr);
               editor.commit();

                if (!namestr.isEmpty() & !phonestr.isEmpty() & awesomeValidation.validate()) {

                    Toast.makeText(signin.this, "Welcome to B.safe", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), mainpage.class);
                    intent.putExtra("Value", namestr);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(signin.this, "Enter Name and Phone Number",
                            Toast.LENGTH_SHORT)
                            .show();
                }

               // if (!sn.isEmpty()) {
                 //   Intent intent = new Intent(getApplicationContext(), mainpage.class);

                 //   intent.putExtra("Value", st);
                  //  startActivity(intent);
                //}
                //else
                //{
                  //  Toast.makeText(signin.this, "Enter Phone Number",
                    //        Toast.LENGTH_SHORT)
                      //      .show();
               // }


            }
        });
    }
}