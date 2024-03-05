package com.sin.rickandmorty.connection;

import com.sin.rickandmorty.response.CharacterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
    @GET("/character")
    Call<CharacterResponse> getCharacter(@Query("page") String page);
}
