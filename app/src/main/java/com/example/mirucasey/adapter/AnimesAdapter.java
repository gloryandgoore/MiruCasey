package com.example.mirucasey.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mirucasey.AnimeDetails;
import com.example.mirucasey.R;
import com.example.mirucasey.model.Anime;
import com.example.mirucasey.model.AnimeObject;

import java.util.ArrayList;

public class AnimesAdapter extends
        RecyclerView.Adapter<AnimesAdapter.AnimeViewHolder> {

    public interface ItemListener{
        void gettingAnimeCompleted(Anime[] list);

        void onClicked(int post);
    }

    Context context;
    public ArrayList<Anime> list;
    public ItemListener listener;

    public AnimesAdapter(Context context, ArrayList<Anime> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_wish_list,parent,false);
        return new AnimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
//        holder.animeImage.setImageBitmap(list.get(position).Anime);
        holder.animeTitle.setText(list.get(position).animeName);
////        Glide.with(context).load(list.get(position).getClass()).into(holder.itemImage);
////
////        holder.animeImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//           public void onClick(View view) {
//Intent intent = new Intent(context, AnimeDetails.class);
//               intent.putExtra("animeId", list.get(position).);
//               intent.putExtra("animeName",genreItemList.get(position).getAnimeName());
//              intent.putExtra("animeImageUrl",genreItemList.get(position).getImageUrl());
//              intent.putExtra("animeSynopsis",genreItemList.get(position).getSynopsis());
//               context.startActivity(intent);}});
//        holder.animeImage.getI
    }


        @Override
    public int getItemCount() {
        return list.size();
    }

    // inner class
    public class AnimeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener
    {
        TextView animeTitle;
//        TextView countryText;
//        ImageView animeImage;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            animeTitle =  itemView.findViewById(R.id.item_text_wish);
//            countryText =  itemView.findViewById(R.id.country);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClicked( getAdapterPosition());

        }
    }


}


