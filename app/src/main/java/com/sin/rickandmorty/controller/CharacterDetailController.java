package com.sin.rickandmorty.controller;

import android.content.Context;
import android.location.Location;
import android.widget.Toast;

import com.sin.rickandmorty.connection.Client;
import com.sin.rickandmorty.response.LocationDataResponse;
import com.sin.rickandmorty.view.CharacterDetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetailController {

    private CharacterDetailActivity mActivity;
    private Context mContext;

    public CharacterDetailController(CharacterDetailActivity mActivity, Context mContext) {
        this.mActivity = mActivity;
        this.mContext = mContext;
    }

    public void getLocation(String name){
        Client.getInstance().getLocation(name).enqueue(new Callback<LocationDataResponse>() {
            @Override
            public void onResponse(Call<LocationDataResponse> call, Response<LocationDataResponse> response) {
                LocationDataResponse locationDataResponse = response.body();
                mActivity.validateLocation(locationDataResponse);
            }

            @Override
            public void onFailure(Call<LocationDataResponse> call, Throwable t) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
