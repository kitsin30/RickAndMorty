package com.sin.rickandmorty.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sin.rickandmorty.R;
import com.squareup.picasso.Picasso;

public class CharacterDetailActivity extends AppCompatActivity {

    private ImageView ivChara;
    private TextView tvCharaName, tvCharaGender, tvCharaStatus, tvCharaSpecies, tvCharaOrigin, tvCharaDate, tvCharaTime;
    private EditText etLocation;

    private String charaImage, charaName, charaGender, charaStatus, charaSpecies, charaOrigin, charaDate, charaTime, charaCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        init();
    }

    private void init(){
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
    }
}