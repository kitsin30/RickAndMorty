package com.sin.rickandmorty.response;

import java.util.ArrayList;

public class LocationCharaDataResponse {

    private String locationName;

    private ArrayList<CharacterInLocationResponse> characterInLocationResponses;

    public LocationCharaDataResponse(String locationName) {
        this.locationName = locationName;
        this.characterInLocationResponses = new ArrayList<>();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public ArrayList<CharacterInLocationResponse> getCharacterInLocationResponses() {
        return characterInLocationResponses;
    }

    public void setCharacterInLocationResponses(CharacterInLocationResponse characterInLocationResponses) {
        this.characterInLocationResponses.add(characterInLocationResponses);
    }
}
