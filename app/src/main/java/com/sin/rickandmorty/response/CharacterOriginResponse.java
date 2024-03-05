package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

public class CharacterOriginResponse {

    @SerializedName("name")
    private String originName;
    @SerializedName("url")
    private String url;

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
