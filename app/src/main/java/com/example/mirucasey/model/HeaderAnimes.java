package com.example.mirucasey.model;

import java.util.List;

public class HeaderAnimes {

    Integer id;
    String animeName;
    String imageUrl;
    String synopsis;
    List<Genres> animeGenre;


    public HeaderAnimes(Integer id, String animeName, String imageUrl, String synopsis, List<Genres> animeGenre) {
        this.id = id;
        this.animeName = animeName;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        this.animeGenre = animeGenre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Genres> getAnimeGenre() {
        return animeGenre;
    }

    public void setAnimeGenre(List<Genres> animeGenre) {
        this.animeGenre = animeGenre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
