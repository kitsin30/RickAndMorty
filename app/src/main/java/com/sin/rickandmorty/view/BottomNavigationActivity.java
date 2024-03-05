package com.sin.rickandmorty.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sin.rickandmorty.R;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
    }
}