package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

public class CharacterLocationResponse {

    @SerializedName("name")
    private String locationName;
    @SerializedName("url")
    private String url;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
