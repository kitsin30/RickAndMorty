package com.sin.rickandmorty.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sin.rickandmorty.R;
import com.sin.rickandmorty.response.CharacterDetailResponse;
import com.sin.rickandmorty.response.LocationCharaDataResponse;
import com.sin.rickandmorty.response.LocationResponse;

import java.util.ArrayList;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ItemViewHolder>{

    Context context;
    private ArrayList<LocationCharaDataResponse> locationCharaDataResponseArrayList;

    public LocationListAdapter(Context context, ArrayList<LocationCharaDataResponse> locationCharaDataResponseArrayList) {
        this.context = context;
        this.locationCharaDataResponseArrayList = locationCharaDataResponseArrayList;
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

        holder.tvLocationName.setText(locationCharaDataResponseArrayList.get(position).getLocationName());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return locationCharaDataResponseArrayList.size();
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
