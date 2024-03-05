package com.sin.rickandmorty.connection;

import com.sin.rickandmorty.response.CharacterResponse;
import com.sin.rickandmorty.response.LocationDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClientServices {
    @GET("/api/character")
    Call<CharacterResponse> getCharacter(@Query("page") String page);

    @GET("/api/location")
    Call<LocationDataResponse> getLocation(@Query("name") String name);
}
