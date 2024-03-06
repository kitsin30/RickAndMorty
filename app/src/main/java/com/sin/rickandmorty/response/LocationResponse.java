package com.sin.rickandmorty.response;

import java.util.ArrayList;

public class LocationResponse {

    ArrayList<LocationCharaDataResponse> locationCharaDataResponseArrayList;

    public LocationResponse() {
        this.locationCharaDataResponseArrayList = new ArrayList<>();
    }

    public ArrayList<LocationCharaDataResponse> getLocationCharaDataResponseArrayList() {
        return locationCharaDataResponseArrayList;
    }

    public void setLocationCharaDataResponseArrayList(LocationCharaDataResponse locationCharaDataResponseArrayList) {
        this.locationCharaDataResponseArrayList.add(locationCharaDataResponseArrayList);
    }

}
