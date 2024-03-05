package com.sin.rickandmorty.controller;

import android.content.Context;
import android.widget.Toast;

import com.sin.rickandmorty.connection.Client;
import com.sin.rickandmorty.response.CharacterResponse;
import com.sin.rickandmorty.view.CharacterListFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterListController {
    private CharacterListFragment mFragment;
    private Context mContext;

    public CharacterListController(CharacterListFragment characterListFragment, Context context) {
        this.mFragment = characterListFragment;
        this.mContext = context;
    }

    public void getCharacterList(String num){
        Client.getInstance().getCharacter(num).enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                CharacterResponse characterResponse = response.body();
                mFragment.setListDataAdapter(characterResponse);
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
