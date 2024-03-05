package com.sin.rickandmorty.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://rickandmortyapi.com/api";

    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
