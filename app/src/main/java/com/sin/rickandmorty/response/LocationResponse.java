package com.sin.rickandmorty.response;

import java.util.ArrayList;

public class LocationResponse {

    ArrayList<LocationCharaDataResponse> locationCharaDataResponseArrayList;

    public ArrayList<LocationCharaDataResponse> getLocationCharaDataResponseArrayList() {
        return locationCharaDataResponseArrayList;
    }

    public void setLocationCharaDataResponseArrayList(ArrayList<LocationCharaDataResponse> locationCharaDataResponseArrayList) {
        this.locationCharaDataResponseArrayList = locationCharaDataResponseArrayList;
    }

}
