package com.sin.rickandmorty.response;

import java.util.ArrayList;

public class LocationCharaDataResponse {

    String locationName;

    ArrayList<CharacterDetailResponse> characterOnThatPositionArrayList;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public ArrayList<CharacterDetailResponse> getCharacterOnThatPositionArrayList() {
        return characterOnThatPositionArrayList;
    }

    public void setCharacterOnThatPositionArrayList(ArrayList<CharacterDetailResponse> characterOnThatPositionArrayList) {
        this.characterOnThatPositionArrayList = characterOnThatPositionArrayList;
    }
}
