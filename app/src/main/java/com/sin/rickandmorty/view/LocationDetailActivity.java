package com.sin.rickandmorty.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sin.rickandmorty.R;
import com.sin.rickandmorty.SharedPref;
import com.sin.rickandmorty.response.LocationResponse;

public class LocationDetailActivity extends AppCompatActivity {

    private TextView tvLocationTitle;
    RecyclerView rvCharaName;

    LocationResponse locationResponse;

    String locationTitle;
    int idx = 0;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        init();
    }

    private void init(){
        tvLocationTitle = (TextView) findViewById(R.id.tv_location_title);
        rvCharaName = (RecyclerView) findViewById(R.id.rv_character_location);

        locationTitle = getIntent().getExtras().getString("location_title");

        tvLocationTitle.setText(locationTitle);

        setData();

        setRvLocationChara();
    }

    private void setData(){
        pref = getSharedPreferences(SharedPref.PREF, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString(SharedPref.LOCATION, "");
        locationResponse = gson.fromJson(json, LocationResponse.class);

        for(int i = 0; i<locationResponse.getLocationCharaDataResponseArrayList().size(); i++){
            if(locationResponse.getLocationCharaDataResponseArrayList().get(i).getLocationName().equals(locationTitle)){
                idx = i;
                break;
            }
        }
    }

    private void setRvLocationChara(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        rvCharaName.setLayoutManager(linearLayoutManager);
        LocationCharaAdapter locationCharaAdapter = new LocationCharaAdapter(this,locationResponse.getLocationCharaDataResponseArrayList().get(idx).getCharacterInLocationResponses());
        rvCharaName.setAdapter(locationCharaAdapter);
    }
}