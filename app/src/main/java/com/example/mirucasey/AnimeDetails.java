package com.example.mirucasey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mirucasey.model.Anime;
import com.example.mirucasey.model.AnimeObject;
import com.example.mirucasey.model.JsonService;
import com.example.mirucasey.service.NetworkingService;

public class AnimeDetails extends AppCompatActivity implements NetworkingService.NetworkingListener {
    ImageView animeImage;
    TextView animeName;
    TextView animeSynopsis;
    Button button_wish;
    AnimeObject obj;


    String name, image, id, synopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_details);
        animeImage = findViewById(R.id.anime_image);
        animeName = findViewById(R.id.anime_name);
        animeSynopsis = findViewById(R.id.anime_synopsis);
        button_wish = findViewById(R.id.button_wish_list);

        id = getIntent().getStringExtra("animeId");
        name = getIntent().getStringExtra("animeName");
        image = getIntent().getStringExtra("animeImageUrl");
        synopsis = getIntent().getStringExtra("animeSynopsis");

        if( getIntent().hasExtra("anime")) {
            Anime w = getIntent().getParcelableExtra("anime");
            animeName.setText(name);
            animeSynopsis.setText(synopsis);
            ((MyApp) getApplication()).networkingService.listener = this;
            ((MyApp) getApplication()).networkingService.getDetailsOfSelectedAnime(w);
        }
        Glide.with(this).load(image).into(animeImage);


    }

    @Override
    public void gettingJsonIsCompleted(String json) {
        obj = JsonService.fromJsonToAnime(json);
//        ((MyApp) getApplication()).networkingService.gettingImage(wo.icon);

    }
}