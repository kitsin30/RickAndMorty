package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CharacterInLocationResponse {

    private String name;
    private String status;
    private String gender;
    private String image;

    public CharacterInLocationResponse(String name, String status, String gender, String image) {
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
