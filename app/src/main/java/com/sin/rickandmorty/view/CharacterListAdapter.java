package com.sin.rickandmorty.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sin.rickandmorty.R;
import com.sin.rickandmorty.response.CharacterDetailResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ItemViewHolder> {

    Context context;
    private ArrayList<CharacterDetailResponse> characterDetailResponses;

    public CharacterListAdapter(Context context, ArrayList<CharacterDetailResponse> characterDetailResponses) {
        this.context = context;
        this.characterDetailResponses = characterDetailResponses;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_item, parent, false);

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        if(position == 0){
            holder.viewLine.setVisibility(View.GONE);
        } else{
            holder.viewLine.setVisibility(View.VISIBLE);
        }

        holder.tvCharaName.setText(characterDetailResponses.get(position).getName());
        holder.tvCharaGender.setText(characterDetailResponses.get(position).getGender());
        holder.tvCharaStatus.setText(characterDetailResponses.get(position).getStatus());

        Picasso.get().load(characterDetailResponses.get(position).getImage()).into(holder.ivCharacter);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CharacterDetailActivity.class);
                intent.putExtra("image_chara", characterDetailResponses.get(position).getImage());
                intent.putExtra("name", characterDetailResponses.get(position).getName());
                intent.putExtra("gender", characterDetailResponses.get(position).getGender());
                intent.putExtra("status", characterDetailResponses.get(position).getStatus());
                intent.putExtra("species", characterDetailResponses.get(position).getSpecies());
                intent.putExtra("origin", characterDetailResponses.get(position).getCharacterOrigin().getOriginName());
                intent.putExtra("created", characterDetailResponses.get(position).getCreated());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterDetailResponses.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        View viewLine;
        ImageView ivCharacter;
        TextView tvCharaName, tvCharaGender, tvCharaStatus;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            viewLine = (View) itemView.findViewById(R.id.view_line);
            ivCharacter = (ImageView) itemView.findViewById(R.id.iv_chara);
            tvCharaName = (TextView) itemView.findViewById(R.id.tv_chara_name);
            tvCharaGender = (TextView) itemView.findViewById(R.id.tv_chara_gender);
            tvCharaStatus = (TextView) itemView.findViewById(R.id.tv_chara_status);
        }
    }
}
