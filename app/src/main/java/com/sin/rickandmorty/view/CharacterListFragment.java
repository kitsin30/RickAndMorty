package com.sin.rickandmorty.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sin.rickandmorty.R;
import com.sin.rickandmorty.controller.CharacterListController;
import com.sin.rickandmorty.response.CharacterResponse;


public class CharacterListFragment extends Fragment {

    RecyclerView rvCharacterList;
    private EditText etPaging;

    private CharacterListController mController;

    public CharacterListFragment() {
        // Required empty public constructor
    }

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
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        rvCharacterList = view.findViewById(R.id.rv_character_list);

        mController = new CharacterListController(this, this.getActivity().getApplicationContext());
        mController.getCharacterList();
    }

    public void setListDataAdapter(CharacterResponse characterResponse){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        rvCharacterList.setLayoutManager(linearLayoutManager);
        CharacterListAdapter characterListAdapter = new CharacterListAdapter(this.getActivity().getApplicationContext(), characterResponse.getCharacterDetailResponsesList());
        rvCharacterList.setAdapter(characterListAdapter);
    }

}