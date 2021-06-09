package com.example.bsafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class drawerlayout extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_drawerlayout);
        drawerLayout= findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        NavigationView nav_menu = (NavigationView)findViewById(R.id.nav_menu);
        nav_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.menu_info:
                        startActivity(new Intent(getApplicationContext(), myinfo.class));
                        overridePendingTransition(0, 0);
                        return true;
//return ;
                    case R.id.menu_contact:
                        startActivity(new Intent(getApplicationContext(), message.class));
                        overridePendingTransition(0, 0);
                        return true;
//return ;
                    case R.id.menu_offline:
                        startActivity(new Intent(getApplicationContext(), bulb.class));
                        overridePendingTransition(0, 0);
                        return true;
//return ;
                    case R.id.menu_rating:
                        startActivity(new Intent(getApplicationContext(), Ratting.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.menu_signout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(drawerlayout.this);
                        builder.setMessage("Do you want to Log Out ?");
                        builder.setCancelable(true);
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), signin.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                }
                return true;
    }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_btn:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }


}