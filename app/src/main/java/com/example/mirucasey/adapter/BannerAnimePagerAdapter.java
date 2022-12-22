package com.example.mirucasey.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.mirucasey.R;

import com.bumptech.glide.Glide;

import com.example.mirucasey.model.HeaderAnimes;

import java.util.List;

public class BannerAnimePagerAdapter extends PagerAdapter {

    Context context;
    List<HeaderAnimes> headerAnimesList;

    public BannerAnimePagerAdapter(Context context, List<HeaderAnimes> headerAnimesList) {
        this.context = context;
        this.headerAnimesList = headerAnimesList;
    }

    @Override
    public int getCount() {
        return headerAnimesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.banner_anime_layout, null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);

        Glide.with(context).load(headerAnimesList.get(0).getImageUrl()).into(bannerImage);
        return bannerImage;
    }
}

//    @NonNull
//    @NotNull
//    @Override
//    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
//        View v = LayoutInflater.from(context).inflate(R.layout.banner_adapter_layout, container, false);
//        ImageView imgView = v.findViewById(R.id.imgBannerImage);
//
//        Glide.with(context).load(moviesList.get(0).getImageUrl()).into(imgView);
//        return imgView;
//    }
//
//    @Override
//    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
//        container.removeView((View) object);
//    }
//}


