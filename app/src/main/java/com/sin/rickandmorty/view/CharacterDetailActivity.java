package com.sin.rickandmorty.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sin.rickandmorty.R;
import com.sin.rickandmorty.SharedPref;
import com.sin.rickandmorty.controller.CharacterDetailController;
import com.sin.rickandmorty.response.CharacterInLocationResponse;
import com.sin.rickandmorty.response.LocationCharaDataResponse;
import com.sin.rickandmorty.response.LocationDataResponse;
import com.sin.rickandmorty.response.LocationResponse;
import com.squareup.picasso.Picasso;

public class CharacterDetailActivity extends AppCompatActivity {

    private ImageView ivChara;
    private TextView tvCharaName, tvCharaGender, tvCharaStatus, tvCharaSpecies, tvCharaOrigin, tvCharaDate, tvCharaTime;
    private EditText etLocation;

    private String charaImage, charaName, charaGender, charaStatus, charaSpecies, charaOrigin, charaDate, charaTime, charaCreated;

    private String locationName;
    private String beforeSearchLocationName;

    private CharacterDetailController mController;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        init();
    }

    private void init(){
        mController = new CharacterDetailController(this, this.getApplicationContext());

        pref = getSharedPreferences(SharedPref.PREF, MODE_PRIVATE);

        ivChara = (ImageView) findViewById(R.id.iv_chara);
        tvCharaName = (TextView) findViewById(R.id.tv_chara_name);
        tvCharaGender = (TextView) findViewById(R.id.tv_chara_gender);
        tvCharaStatus = (TextView) findViewById(R.id.tv_chara_status);
        tvCharaSpecies = (TextView) findViewById(R.id.tv_chara_species);
        tvCharaOrigin = (TextView) findViewById(R.id.tv_chara_origin);
        tvCharaDate = (TextView) findViewById(R.id.tv_chara_date);
        tvCharaTime = (TextView) findViewById(R.id.tv_chara_time);
        etLocation = (EditText) findViewById(R.id.et_location);

        charaImage = getIntent().getExtras().getString("image_chara");
        charaName = getIntent().getExtras().getString("name");
        charaGender = getIntent().getExtras().getString("gender");
        charaStatus = getIntent().getExtras().getString("status");
        charaSpecies = getIntent().getExtras().getString("species");
        charaOrigin = getIntent().getExtras().getString("origin");
        charaCreated = getIntent().getExtras().getString("created");

        charaDate = charaCreated.substring(0,10);
        charaTime = charaCreated.substring(11,19);

        setLocation();

        Picasso.get().load(charaImage).into(ivChara);
        tvCharaName.setText(charaName);
        tvCharaGender.setText(charaGender);
        tvCharaStatus.setText(charaStatus);
        tvCharaSpecies.setText(charaSpecies);
        tvCharaOrigin.setText(charaOrigin);
        tvCharaDate.setText(charaDate);
        tvCharaTime.setText(charaTime);

        etLocation.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    locationName = etLocation.getText().toString();
                    mController.getLocation(locationName);
                    return true;
                }
                return false;
            }
        });
    }

    public void setLocation(){
        Gson gson = new Gson();
        String json = pref.getString(SharedPref.LOCATION, "");
        LocationResponse locationResponse = gson.fromJson(json, LocationResponse.class);

        if(locationResponse == null){
            etLocation.setText("");
            return;
        }

        int idxLocation = -1;
        int idxChara = -1;

        for(int i = 0; i<locationResponse.getLocationCharaDataResponseArrayList().size(); i++){
            for (int j = 0; j < locationResponse.getLocationCharaDataResponseArrayList().get(i).getCharacterInLocationResponses().size(); j++) {
                if (locationResponse.getLocationCharaDataResponseArrayList().get(i).
                        getCharacterInLocationResponses().get(j).getName().equals(charaName)) {
                    idxChara = j;
                    idxLocation = i;
                    break;
                }
            }
        }

        if(idxChara == -1){
            etLocation.setText("");
        } else{
            etLocation.setText(locationResponse.getLocationCharaDataResponseArrayList().get(idxLocation).getLocationName());
        }

    }

    public void validateLocation(LocationDataResponse locationDataResponse){
        int idx = -1;
        if(locationDataResponse == null){
            Toast.makeText(this, R.string.wrong_location, Toast.LENGTH_LONG).show();
        } else if(locationDataResponse.getLocationResult().size() > 0){
            for(int i = 0; i<locationDataResponse.getLocationResult().size(); i++){
                if(locationDataResponse.getLocationResult().get(i).getName().equals(locationName)){
                    idx = i;
                    break;
                }
            }
        } else{
            Toast.makeText(this, R.string.wrong_location, Toast.LENGTH_LONG).show();
        }

        if(idx==-1){
            Toast.makeText(this, R.string.wrong_location, Toast.LENGTH_LONG).show();
        } else{

            Gson gson = new Gson();
            String json = pref.getString(SharedPref.LOCATION, "");
            LocationResponse locationResponse = gson.fromJson(json, LocationResponse.class);

            if(locationResponse == null){
                locationResponse = new LocationResponse();

                LocationCharaDataResponse locationCharaDataResponse = new LocationCharaDataResponse(locationName);

                CharacterInLocationResponse characterInLocationResponse = new CharacterInLocationResponse(charaName, charaStatus, charaGender, charaImage);

                locationCharaDataResponse.setCharacterInLocationResponses(characterInLocationResponse);

                locationResponse.setLocationCharaDataResponseArrayList(locationCharaDataResponse);

                editPref(locationResponse);

            } else{
                int idxLocation = -1;
                int idxChara = -1;

                for(int i = 0; i<locationResponse.getLocationCharaDataResponseArrayList().size(); i++){
                    if(locationResponse.getLocationCharaDataResponseArrayList().get(i).getLocationName().equals(locationName)) {
                        idxLocation = i;
                        for (int j = 0; j < locationResponse.getLocationCharaDataResponseArrayList().get(i).getCharacterInLocationResponses().size(); j++) {

                            if (locationResponse.getLocationCharaDataResponseArrayList().get(i).
                                    getCharacterInLocationResponses().get(j).getName().equals(charaName)) {
                                idxChara = j;
                                break;
                            }
                        }
                        break;
                    }
                }

                if(idxLocation == -1){
                    LocationCharaDataResponse locationCharaDataResponse = new LocationCharaDataResponse(locationName);

                    CharacterInLocationResponse characterInLocationResponse = new CharacterInLocationResponse(charaName, charaStatus, charaGender, charaImage);

                    locationCharaDataResponse.setCharacterInLocationResponses(characterInLocationResponse);

                    locationResponse.setLocationCharaDataResponseArrayList(locationCharaDataResponse);

                    editPref(locationResponse);
                } else{
                    if(idxChara != -1){
                        Toast.makeText(this, R.string.already_here, Toast.LENGTH_LONG).show();
                    } else{
                        CharacterInLocationResponse characterInLocationResponse = new CharacterInLocationResponse(charaName, charaStatus, charaGender, charaImage);

                        locationResponse.getLocationCharaDataResponseArrayList().get(idxLocation).setCharacterInLocationResponses(characterInLocationResponse);

                        editPref(locationResponse);
                    }
                }

                if(beforeSearchLocationName.length() > 0){
                    beforeSearchLocation(locationResponse);
                }

                Toast.makeText(this, R.string.already_here, Toast.LENGTH_LONG).show();

            }
        }
    }

    private void editPref(LocationResponse locationResponse){
        //insert to sharedpref
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String jsonInsert = gson.toJson(locationResponse);
        editor.putString(SharedPref.LOCATION, jsonInsert);
        editor.commit();
    }

    private void beforeSearchLocation(LocationResponse locationResponse){
        int idxLocation = -1;
        int idxChara = -1;

        for(int i = 0; i<locationResponse.getLocationCharaDataResponseArrayList().size(); i++){
            if(locationResponse.getLocationCharaDataResponseArrayList().get(i).getLocationName().equals(beforeSearchLocationName)) {
                idxLocation = i;
                for (int j = 0; j < locationResponse.getLocationCharaDataResponseArrayList().get(i).getCharacterInLocationResponses().size(); j++) {

                    if (locationResponse.getLocationCharaDataResponseArrayList().get(i).
                            getCharacterInLocationResponses().get(j).getName().equals(charaName)) {
                        idxChara = j;
                        break;
                    }
                }
                break;
            }
        }

        if(idxChara != -1){
            locationResponse.getLocationCharaDataResponseArrayList().get(idxLocation).getCharacterInLocationResponses().remove(idxChara);

            editPref(locationResponse);
        }

    }
}