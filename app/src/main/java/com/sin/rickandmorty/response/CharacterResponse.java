package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CharacterResponse {

    @SerializedName("info")
    private PageInfoResponse pageInfoResponsesList;

    @SerializedName("results")
    private ArrayList<CharacterDetailResponse> characterDetailResponsesList;

    public PageInfoResponse getPageInfoResponsesList() {
        return pageInfoResponsesList;
    }

    public void setPageInfoResponsesList(PageInfoResponse pageInfoResponsesList) {
        this.pageInfoResponsesList = pageInfoResponsesList;
    }

    public ArrayList<CharacterDetailResponse> getCharacterDetailResponsesList() {
        return characterDetailResponsesList;
    }

    public void setCharacterDetailResponsesList(ArrayList<CharacterDetailResponse> characterDetailResponsesList) {
        this.characterDetailResponsesList = characterDetailResponsesList;
    }
}
