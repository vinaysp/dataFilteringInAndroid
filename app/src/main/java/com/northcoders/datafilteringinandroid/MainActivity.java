package com.northcoders.datafilteringinandroid;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView

        .OnItemSelectedListener{

    NavigationBarView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(this);

        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    HomeFragment homeFragment = new HomeFragment();
    AddFragment addFragment = new AddFragment();
    FavouritesFragment favouritesFragment = new FavouritesFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.home){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,homeFragment)
                    .commit();
            return true;
        }
        if(item.getItemId() == R.id.add){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,addFragment)
                    .commit();
            return true;
        }
        if(item.getItemId() == R.id.favourites){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,favouritesFragment)
                    .commit();
            return true;
        }

        return false;
    }
}