package com.example.mirucasey.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mirucasey.AnimeDetails;
import com.example.mirucasey.MainActivity;
import com.example.mirucasey.MyApp;
import com.example.mirucasey.R;
import com.example.mirucasey.adapter.AnimesAdapter;
import com.example.mirucasey.service.DBManager;

import java.util.ArrayList;
import java.util.Arrays;

public class WishList extends AppCompatActivity implements DBManager.DataBaseListener, AnimesAdapter.ItemListener {

    AnimesAdapter adapter;
    ImageView animeImage;
    TextView animeName;
    ArrayList<Anime> animeList = new ArrayList<>(0);

//    String name, image, id, synopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
//        animeImage = findViewById(R.id.item_image_wish);
        this.setTitle("Wish List");
        RecyclerView wishList = findViewById(R.id.item_wish_recycler);

//        id = getIntent().getStringExtra("animeId");
//        name = getIntent().getStringExtra("animeName");
//        image = getIntent().getStringExtra("animeImageUrl");
//        synopsis = getIntent().getStringExtra("animeSynopsis");

        adapter = new AnimesAdapter(this, animeList);
        wishList.setAdapter(adapter);
        adapter.listener = this;
        wishList.setLayoutManager(new LinearLayoutManager(this));


//        Glide.with(this).load(image).into(animeImage);
//        animeName.setText(name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyApp) getApplication()).dbManager.getAnimeDB(this);
        ((MyApp) getApplication()).dbManager.getAllAnimes();
        ((MyApp) getApplication()).dbManager.listener = this;

    }


    @Override
    public void insertingAnimeCompleted() {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addButton:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        };
        return true;
    }

    @Override
    public void gettingAnimeCompleted(Anime[] list) {
        animeList = new ArrayList(Arrays.asList(list));
        adapter.list = animeList;
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClicked(int post) {
        Intent i = new Intent(this, AnimeDetails.class);
        i.putExtra("anime", animeList.get(post));
        startActivity(i);

    }
}

