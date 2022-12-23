package com.example.mirucasey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnimeDetails extends AppCompatActivity {
    ImageView animeImage;
    TextView animeName;
    Button button_wish;


    String name, image, id, fileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_details);
        animeImage = findViewById(R.id.anime_image);
        animeName = findViewById(R.id.anime_name);
        button_wish = findViewById(R.id.button_wish_list);

        id = getIntent().getStringExtra("animeId");
        name = getIntent().getStringExtra("animeName");
        image = getIntent().getStringExtra("animeImageUrl");
        fileUrl = getIntent().getStringExtra("animeFile");


        Glide.with(this).load(image).into(animeImage);
        animeName.setText(name);

    }
}