package com.sin.rickandmorty.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sin.rickandmorty.R;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bnvNavbar;

    CharacterListFragment characterListFragment = new CharacterListFragment();
    LocationFragment locationFragment = new LocationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        init();
    }

    private void init(){
        bnvNavbar = (BottomNavigationView) findViewById(R.id.bnv_navbar);
        bnvNavbar.setOnItemSelectedListener(this);
        bnvNavbar.setSelectedItemId(R.id.character_menu);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.character_menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_main_content, characterListFragment)
                        .commit();
                return true;
            case R.id.location_menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_main_content, locationFragment)
                        .commit();
                return true;
        }
        return false;
    }
}