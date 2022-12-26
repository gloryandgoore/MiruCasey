package com.example.mirucasey.model;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;

public class AnimeObject {
    Integer id;
    String animeName;
    String imageUrl;
    String synopsis;
    JSONArray animeGenres;

    public AnimeObject(){

    }

    public AnimeObject(Integer id, String animeName, String imageUrl, String synopsis, JSONArray animeGenres) {
        this.id = id;
        this.animeName = animeName;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        this.animeGenres = animeGenres;
    }
}


