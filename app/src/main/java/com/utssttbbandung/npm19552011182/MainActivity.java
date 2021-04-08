package com.utssttbbandung.npm19552011182;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentPage(new com.utssttbbandung.npm19552011182.HomeFragment());

        bottomNavigationItemView = findViewById(R.id.btnNavView);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda_menu:
                        getFragmentPage(new com.utssttbbandung.npm19552011182.HomeFragment());
                        break;
                    case R.id.tentang_menu:
                        getFragmentPage(new com.utssttbbandung.npm19552011182.AboutFragment());
                        break;
                }
                return true;
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.FLContainer, fragment)
                    .commit();
            return true;
        }
        return true;
    }

    // Menset Perubahan title bar
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}