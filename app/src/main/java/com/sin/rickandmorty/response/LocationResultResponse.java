package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LocationResultResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("dimension")
    private String dimension;
    @SerializedName("residents")
    private ArrayList<String> residents;
    @SerializedName("url")
    private String url;
    @SerializedName("created")
    private String created;
}
