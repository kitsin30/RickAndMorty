package com.sin.rickandmorty.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sin.rickandmorty.R;


public class CharacterListFragment extends Fragment {

    public CharacterListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CharacterListFragment newInstance() {
        CharacterListFragment fragment = new CharacterListFragment();
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
        return inflater.inflate(R.layout.fragment_character_list, container, false);
    }
}