package com.sin.rickandmorty.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LocationDataResponse {

    @SerializedName("info")
    private PageInfoResponse pageInfoResponsesList;

    @SerializedName("results")
    private ArrayList<LocationResultResponse> locationResult;

    public PageInfoResponse getPageInfoResponsesList() {
        return pageInfoResponsesList;
    }

    public void setPageInfoResponsesList(PageInfoResponse pageInfoResponsesList) {
        this.pageInfoResponsesList = pageInfoResponsesList;
    }

    public ArrayList<LocationResultResponse> getLocationResult() {
        return locationResult;
    }

    public void setLocationResult(ArrayList<LocationResultResponse> locationResult) {
        this.locationResult = locationResult;
    }
}
