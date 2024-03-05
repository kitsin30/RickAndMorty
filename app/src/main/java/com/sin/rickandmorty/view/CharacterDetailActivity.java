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

import com.sin.rickandmorty.R;
import com.sin.rickandmorty.controller.CharacterDetailController;
import com.sin.rickandmorty.response.LocationDataResponse;
import com.squareup.picasso.Picasso;

public class CharacterDetailActivity extends AppCompatActivity {

    private ImageView ivChara;
    private TextView tvCharaName, tvCharaGender, tvCharaStatus, tvCharaSpecies, tvCharaOrigin, tvCharaDate, tvCharaTime;
    private EditText etLocation;

    private String charaImage, charaName, charaGender, charaStatus, charaSpecies, charaOrigin, charaDate, charaTime, charaCreated;

    private CharacterDetailController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        init();
    }

    private void init(){
        mController = new CharacterDetailController(this, this.getApplicationContext());

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
                    mController.getLocation(etLocation.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    public void validateLocation(LocationDataResponse locationDataResponse){
        int idx = -1;
        if(locationDataResponse.getLocationResult().size() > 0){
            for(int i = 0; i<locationDataResponse.getLocationResult().size(); i++){
                if(locationDataResponse.getLocationResult().get(i).equals(etLocation.getText().toString())){
                    idx = i;
                    break;
                }
            }
        } else{
            Toast.makeText(this, "wrong location", Toast.LENGTH_LONG).show();
        }

        if(idx==-1){
            Toast.makeText(this, "wrong location", Toast.LENGTH_LONG).show();
        } else{
            SharedPreferences sharedPreferences;
        }
    }
}