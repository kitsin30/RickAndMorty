package com.sin.rickandmorty.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sin.rickandmorty.R;
import com.sin.rickandmorty.response.CharacterInLocationResponse;

import java.util.ArrayList;

public class LocationCharaAdapter extends RecyclerView.Adapter<LocationCharaAdapter.ItemViewHolder>{

    Context context;
    private ArrayList<CharacterInLocationResponse> characterInLocationResponses;

    public LocationCharaAdapter(Context context, ArrayList<CharacterInLocationResponse> characterInLocationResponses) {
        this.context = context;
        this.characterInLocationResponses = characterInLocationResponses;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_list_item, parent, false);

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if(position == 0){
            holder.viewLine.setVisibility(View.GONE);
        } else{
            holder.viewLine.setVisibility(View.VISIBLE);
        }

        holder.tvLocationName.setText(characterInLocationResponses.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return characterInLocationResponses.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        View viewLine;
        TextView tvLocationName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            viewLine = (View) itemView.findViewById(R.id.view_line);
            tvLocationName = (TextView) itemView.findViewById(R.id.tv_location_name);
        }
    }
}
