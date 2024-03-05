package com.sin.rickandmorty.response;

import java.util.ArrayList;

public class CharacterResponse {

    private PageInfoResponse pageInfoResponsesList;
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
