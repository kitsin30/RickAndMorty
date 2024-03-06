package com.sin.rickandmorty.view;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.sin.rickandmorty.R;
import com.sin.rickandmorty.SharedPref;
import com.sin.rickandmorty.response.LocationResponse;

public class LocationFragment extends Fragment {

    RecyclerView rvLocationList;

    SharedPreferences pref;

    LocationResponse locationResponse;

    public LocationFragment() {
        // Required empty public constructor
    }

    public static LocationFragment newInstance() {
        LocationFragment fragment = new LocationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        pref = getActivity().getSharedPreferences(SharedPref.PREF, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString(SharedPref.LOCATION, "");
        locationResponse = gson.fromJson(json, LocationResponse.class);

        rvLocationList = view.findViewById(R.id.rv_location_list);

        if(locationResponse == null){
            rvLocationList.setVisibility(View.GONE);
        } else{
            rvLocationList.setVisibility(View.VISIBLE);
        }
        setLocationListAdapter();
    }

    void setLocationListAdapter(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        rvLocationList.setLayoutManager(linearLayoutManager);
        LocationListAdapter locationListAdapter = new LocationListAdapter(this.getActivity().getApplicationContext(), locationResponse.getLocationCharaDataResponseArrayList());
        rvLocationList.setAdapter(locationListAdapter);
    }
}